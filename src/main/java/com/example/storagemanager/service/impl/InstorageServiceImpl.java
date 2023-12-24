package com.example.storagemanager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.storagemanager.common.Result;
import com.example.storagemanager.entity.Goods;
import com.example.storagemanager.entity.GoodsStorage;
import com.example.storagemanager.entity.Instorage;
import com.example.storagemanager.entity.dto.InOutStoragePageQueryDTO;
import com.example.storagemanager.entity.vo.InOutStorageVO;
import com.example.storagemanager.mapper.GoodsMapper;
import com.example.storagemanager.mapper.GoodsStorageMapper;
import com.example.storagemanager.mapper.InstorageMapper;
import com.example.storagemanager.service.GoodsService;
import com.example.storagemanager.service.InstorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class InstorageServiceImpl extends ServiceImpl<InstorageMapper, Instorage> implements InstorageService {

    @Resource
    private InstorageMapper instorageMapper;

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private GoodsStorageMapper goodsStorageMapper;

    @Override
    public Result<Instorage> add(Instorage instorage) {

        // 校验
        if (instorage.getNum() == null || instorage.getNum() <= 0 || instorage.getStorageId() == null || instorage.getGoodsId() == null || instorage.getUserId() == null)
            return Result.fail("数据校验异常");
        Goods goods = goodsMapper.selectById(instorage.getGoodsId());
        if (goods == null ){
            return Result.fail("商品id无效");
        }
        if (goods.getNum() < instorage.getNum()){
            return Result.fail("入库数量大于商品总量");
        }
        goods.setNum(goods.getNum() - instorage.getNum());
        if (goods.getNum() == 0){
            goodsMapper.deleteById(goods.getId());
        }

        // 更新商品数量
        goodsMapper.updateById(goods);

        // 入库
        // 查询原始库存记录
        QueryWrapper<GoodsStorage> wrapper = new QueryWrapper<>();
        wrapper.eq("goods_id",goods.getId());
        wrapper.eq("storage_id",instorage.getStorageId());
        GoodsStorage gs = goodsStorageMapper.selectOne(wrapper);
        if (gs == null){
            // 新增
            GoodsStorage goodsStorage = new GoodsStorage();
            goodsStorage.setGoodsId(goods.getId());
            goodsStorage.setStorageId(instorage.getStorageId());
            goodsStorage.setNum(instorage.getNum());
            goodsStorageMapper.insert(goodsStorage);
        }else {
            // 更新
            gs.setNum(gs.getNum() + instorage.getNum());
            goodsStorageMapper.updateById(gs);
        }

        // 添加入库记录
        instorageMapper.insert(instorage);
        return Result.success(instorage);
    }

    @Override
    public Result<List<InOutStorageVO>> pageQuery(InOutStoragePageQueryDTO dto) {
        int offset = (dto.getPage() - 1) * dto.getPageSize();
        dto.setPage(offset);
        List<InOutStorageVO> list = instorageMapper.pageQuery(dto);
        return Result.success(list);
    }
}
