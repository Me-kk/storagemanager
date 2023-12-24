package com.example.storagemanager.mapper;

import com.example.storagemanager.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.storagemanager.entity.dto.PageQueryGoodsDTO;
import com.example.storagemanager.entity.vo.GoodsDetailVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author guopei
 * @since 2023-12-19
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    List<GoodsDetailVO> pageQuery(PageQueryGoodsDTO dto);

    long countQuery(PageQueryGoodsDTO dto);

}
