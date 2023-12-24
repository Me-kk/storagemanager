package com.example.storagemanager.controller;


import com.example.storagemanager.common.Result;
import com.example.storagemanager.entity.Instorage;
import com.example.storagemanager.entity.dto.InOutStoragePageQueryDTO;
import com.example.storagemanager.entity.vo.InOutStorageVO;
import com.example.storagemanager.service.InstorageService;
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
@RequestMapping("/instorage")
@Api(tags = "入库管理")
@CrossOrigin
public class InstorageController {

    @Resource
    private InstorageService instorageService;

    @PostMapping
    @ApiOperation("商品入库")
    public Result<Instorage> add(@RequestBody Instorage instorage){
        return instorageService.add(instorage);
    }

    @PostMapping("/list")
    @ApiOperation("查看入库记录")
    public Result<List<InOutStorageVO>> list(@RequestBody InOutStoragePageQueryDTO dto){
        return instorageService.pageQuery(dto);
    }

}

