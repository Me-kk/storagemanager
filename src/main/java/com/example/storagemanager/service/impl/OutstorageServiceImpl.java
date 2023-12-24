package com.example.storagemanager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.storagemanager.common.Result;
import com.example.storagemanager.entity.GoodsStorage;
import com.example.storagemanager.entity.Outstorage;
import com.example.storagemanager.entity.dto.InOutStoragePageQueryDTO;
import com.example.storagemanager.entity.vo.InOutStorageVO;
import com.example.storagemanager.mapper.GoodsStorageMapper;
import com.example.storagemanager.mapper.OutstorageMapper;
import com.example.storagemanager.service.GoodsService;
import com.example.storagemanager.service.OutstorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.junit.Ignore;
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
public class OutstorageServiceImpl extends ServiceImpl<OutstorageMapper, Outstorage> implements OutstorageService {
    @Resource
    private OutstorageMapper outstorageMapper;

    @Resource
    private GoodsStorageMapper goodsStorageMapper;

    @Override
    public Result<Outstorage> add(Outstorage outstorage) {
        // 校验
        if (outstorage.getNum() == null || outstorage.getNum() <= 0 || outstorage.getGoodsId() == null || outstorage.getUserId() == null){
            return Result.fail("必要参数为空");
        }
        // 查询原库存
        QueryWrapper<GoodsStorage> wrapper = new QueryWrapper<>();
        wrapper.eq("goods_id", outstorage.getGoodsId()).eq("storage_id",outstorage.getStorageId());
        GoodsStorage gs = goodsStorageMapper.selectOne(wrapper);
        if (gs == null){
            return Result.fail("查询不到库存信息");
        }
        if (gs.getNum() <= outstorage.getNum()){
            return Result.fail("出库数量超过仓库中商品的数量");
        }
        // 删除
        if (gs.getNum() - outstorage.getNum() == 0){
            goodsStorageMapper.deleteById(gs.getId());
        }else {
            // 更新
            gs.setNum(gs.getNum() - outstorage.getNum());
            goodsStorageMapper.updateById(gs);
        }
        // 添加出库记录
        outstorageMapper.insert(outstorage);
        return Result.success(outstorage);
    }

    @Override
    public Result<List<InOutStorageVO>> pageQuery(InOutStoragePageQueryDTO dto) {
        int offset = (dto.getPage() - 1) * dto.getPageSize();
        dto.setPage(offset);
        List<InOutStorageVO> list = outstorageMapper.pageQuery(dto);
        return Result.success(list);
    }
}
