package com.example.storagemanager.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.storagemanager.common.Result;
import com.example.storagemanager.entity.Provider;
import com.example.storagemanager.entity.dto.ProviderPageQueryDTO;
import com.example.storagemanager.entity.vo.CommonQueryPageVO;
import com.example.storagemanager.entity.vo.ProviderPageQueryVO;
import com.example.storagemanager.mapper.ProviderMapper;
import com.example.storagemanager.service.ProviderService;
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
public class ProviderServiceImpl extends ServiceImpl<ProviderMapper, Provider> implements ProviderService {
    @Resource
    private ProviderMapper providerMapper;

    @Override
    public Result<Provider> addProvider(Provider provider) {
        providerMapper.insert(provider);
        return Result.success(provider);
    }

    @Override
    public Result<CommonQueryPageVO<Provider>> pageQuery(ProviderPageQueryDTO dto) {
        Page<Provider> page = new Page<>(dto.getPage(),dto.getPageSize());
        Page<Provider> pageRes = providerMapper.selectPage(page, new QueryWrapper<Provider>().like(!StrUtil.isBlank(dto.getProviderName()),"name", dto.getProviderName()));
        CommonQueryPageVO<Provider> vo = new CommonQueryPageVO<>();
        vo.setList(pageRes.getRecords());
        vo.setTotal(pageRes.getTotal());
        return Result.success(vo);
    }
}
