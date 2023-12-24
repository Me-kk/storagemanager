package com.example.storagemanager.controller;


import com.example.storagemanager.common.Result;
import com.example.storagemanager.entity.Outstorage;
import com.example.storagemanager.entity.dto.InOutStoragePageQueryDTO;
import com.example.storagemanager.entity.vo.InOutStorageVO;
import com.example.storagemanager.service.OutstorageService;
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
@RequestMapping("/outstorage")
@Api(tags = "出库管理")
@CrossOrigin
public class OutstorageController {
    @Resource
    private OutstorageService outstorageService;

    @PostMapping
    @ApiOperation("商品出库")
    private Result<Outstorage> add(@RequestBody Outstorage outstorage){
        return outstorageService.add(outstorage);
    }

    @PostMapping("/list")
    @ApiOperation("查看出库记录")
    public Result<List<InOutStorageVO>> list(@RequestBody InOutStoragePageQueryDTO dto){
        return outstorageService.pageQuery(dto);
    }
}

