package com.example.storagemanager.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.storagemanager.common.Result;
import com.example.storagemanager.entity.Goods;
import com.example.storagemanager.entity.dto.PageQueryGoodsDTO;
import com.example.storagemanager.entity.vo.CommonQueryPageVO;
import com.example.storagemanager.entity.vo.GoodsDetailVO;
import com.example.storagemanager.mapper.GoodsMapper;
import com.example.storagemanager.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guopei
 * @since 2023-12-19
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Resource
    private GoodsMapper baseMapper;

    @Override
    public Result<Goods> addGoods(Goods goods) {
        if (goods == null || StrUtil.isBlank(goods.getName()) || goods.getProviderId() == null)
            return Result.fail("关键信息缺失");
        baseMapper.insert(goods);
        return Result.success(goods);
    }

    // 更改商品名字
    @Override
    public Result<Goods> updateGoods(Goods goods) {
        if (goods == null || StrUtil.isBlank(goods.getName()) || goods.getId() == null)
            return Result.fail("关键信息缺失");
        baseMapper.updateById(goods);
        return Result.success(goods);
    }

    @Override
    public Result<String> deleteBatch(List<Integer> ids) {
        return null;
    }

    @Override
    public Result<CommonQueryPageVO<GoodsDetailVO>> pageQuery(PageQueryGoodsDTO dto) {
        dto.setPage((dto.getPage()-1) * dto.getPageSize());
        List<GoodsDetailVO> list = baseMapper.pageQuery(dto);
        ArrayList<GoodsDetailVO> resList = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        list.forEach(vo -> {
            if (vo.getNum() != null){
                if (!set.contains(vo.getGoodsId())){
                    set.add(vo.getGoodsId());
                    GoodsDetailVO detailVO = new GoodsDetailVO();
                    BeanUtil.copyProperties(vo,detailVO);
                    detailVO.setStorageName("未入库");
                    detailVO.setStorageNum(detailVO.getNum());
                    detailVO.setNum(null);
                    resList.add(detailVO);
                }
            }
            if (vo.getStorageNum() != null){
                vo.setNum(null);
                resList.add(vo);
            }
        });
        CommonQueryPageVO<GoodsDetailVO> res = new CommonQueryPageVO<>();
        res.setList(resList);
        res.setTotal(baseMapper.countQuery(dto));
        return Result.success(res);
    }
}
