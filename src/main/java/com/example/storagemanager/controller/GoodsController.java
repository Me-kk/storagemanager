package com.example.storagemanager.controller;


import com.example.storagemanager.common.Result;
import com.example.storagemanager.entity.Goods;
import com.example.storagemanager.entity.dto.PageQueryGoodsDTO;
import com.example.storagemanager.entity.vo.CommonQueryPageVO;
import com.example.storagemanager.entity.vo.GoodsDetailVO;
import com.example.storagemanager.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author guopei
 * @since 2023-12-19
 */
@RestController
@RequestMapping("/goods")
@Api(tags = "商品管理")
@CrossOrigin
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @PostMapping
    @ApiOperation("添加商品")
    public Result<Goods> addGoods(@RequestBody Goods goods){
        return goodsService.addGoods(goods);
    }

    @PostMapping("/update")
    @ApiOperation("商品更新")
    public Result<Goods> updateGoods(@RequestBody Goods goods){
        return goodsService.updateGoods(goods);
    }

    @DeleteMapping
    @ApiOperation("删除商品")
    public Result<String> deleteGoodsList(@RequestBody List<Integer> ids){
        return goodsService.deleteBatch(ids);
    }

    @PostMapping("/list")
    @ApiOperation("获取商品列表")
    public Result<CommonQueryPageVO<GoodsDetailVO>> pageQuery(@RequestBody PageQueryGoodsDTO dto){
        return goodsService.pageQuery(dto);
    }
}

