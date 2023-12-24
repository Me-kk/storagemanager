package com.example.storagemanager.controller;


import com.example.storagemanager.common.Result;
import com.example.storagemanager.entity.Storage;
import com.example.storagemanager.entity.dto.StoragePageQueryDTO;
import com.example.storagemanager.entity.vo.CommonQueryPageVO;
import com.example.storagemanager.service.StorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author guopei
 * @since 2023-12-19
 */
@RestController
@RequestMapping("/storage")
@Api(tags = "仓库管理")
@CrossOrigin
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping
    @ApiOperation("添加仓库")
    public Result<Storage> add(@RequestBody Storage storage){
        return storageService.add(storage);
    }

    @PostMapping("/list")
    @ApiOperation("获取仓库列表")
    public Result<CommonQueryPageVO<Storage>> list(@RequestBody StoragePageQueryDTO dto){
        return storageService.pageQuery(dto);
    }
}

