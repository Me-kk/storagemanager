package com.example.storagemanager.controller;


import com.example.storagemanager.common.Result;
import com.example.storagemanager.entity.Provider;
import com.example.storagemanager.entity.dto.ProviderPageQueryDTO;
import com.example.storagemanager.entity.vo.CommonQueryPageVO;
import com.example.storagemanager.entity.vo.ProviderPageQueryVO;
import com.example.storagemanager.service.ProviderService;
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
@RequestMapping("/provider")
@Api(tags = "供应商管理")
@CrossOrigin
public class ProviderController {

    @Resource
    private ProviderService providerService;

    @PostMapping
    @ApiOperation("添加供应商")
    public Result<Provider> addProvider(@RequestBody Provider provider){
        return providerService.addProvider(provider);
    }

    @PostMapping("/list")
    @ApiOperation("获取供应商列表")
    public Result<CommonQueryPageVO<Provider>> list(@RequestBody ProviderPageQueryDTO dto){
        return providerService.pageQuery(dto);
    }

}

