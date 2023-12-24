package com.example.storagemanager.service;

import com.example.storagemanager.common.Result;
import com.example.storagemanager.entity.Outstorage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.storagemanager.entity.dto.InOutStoragePageQueryDTO;
import com.example.storagemanager.entity.vo.InOutStorageVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guopei
 * @since 2023-12-19
 */
public interface OutstorageService extends IService<Outstorage> {

    Result<Outstorage> add(Outstorage outstorage);

    Result<List<InOutStorageVO>> pageQuery(InOutStoragePageQueryDTO dto);
}
