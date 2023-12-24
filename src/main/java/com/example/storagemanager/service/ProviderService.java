package com.example.storagemanager.service;

import com.example.storagemanager.common.Result;
import com.example.storagemanager.entity.Provider;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.storagemanager.entity.dto.ProviderPageQueryDTO;
import com.example.storagemanager.entity.vo.CommonQueryPageVO;
import com.example.storagemanager.entity.vo.ProviderPageQueryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guopei
 * @since 2023-12-19
 */
public interface ProviderService extends IService<Provider> {

    Result<Provider> addProvider(Provider provider);

    Result<CommonQueryPageVO<Provider>> pageQuery(ProviderPageQueryDTO dto);
}
