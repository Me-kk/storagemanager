package com.example.storagemanager.service;

import com.example.storagemanager.common.Result;
import com.example.storagemanager.entity.Storage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.storagemanager.entity.dto.StoragePageQueryDTO;
import com.example.storagemanager.entity.vo.CommonQueryPageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guopei
 * @since 2023-12-19
 */
public interface StorageService extends IService<Storage> {

    Result<Storage> add(Storage storage);

    Result<CommonQueryPageVO<Storage>> pageQuery(StoragePageQueryDTO dto);
}
