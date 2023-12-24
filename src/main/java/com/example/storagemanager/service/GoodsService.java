package com.example.storagemanager.service;

import com.example.storagemanager.common.Result;
import com.example.storagemanager.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.storagemanager.entity.dto.PageQueryGoodsDTO;
import com.example.storagemanager.entity.vo.CommonQueryPageVO;
import com.example.storagemanager.entity.vo.GoodsDetailVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guopei
 * @since 2023-12-19
 */
public interface GoodsService extends IService<Goods> {

    Result<Goods> addGoods(Goods goods);

    Result<Goods> updateGoods(Goods goods);

    Result<String> deleteBatch(List<Integer> ids);

    Result<CommonQueryPageVO<GoodsDetailVO>> pageQuery(PageQueryGoodsDTO dto);
}
