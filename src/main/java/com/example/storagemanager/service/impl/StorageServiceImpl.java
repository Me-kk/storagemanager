package com.example.storagemanager.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.storagemanager.common.Result;
import com.example.storagemanager.entity.Storage;
import com.example.storagemanager.entity.User;
import com.example.storagemanager.entity.dto.StoragePageQueryDTO;
import com.example.storagemanager.entity.vo.CommonQueryPageVO;
import com.example.storagemanager.mapper.StorageMapper;
import com.example.storagemanager.service.StorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guopei
 * @since 2023-12-19
 */
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public Result<Storage> add(Storage storage) {
        if (StrUtil.isBlank(storage.getAddress()) || StrUtil.isBlank(storage.getName())){
            return Result.fail("关键信息为空");
        }
        storageMapper.insert(storage);
        return Result.success(storage);
    }

    @Override
    public Result<CommonQueryPageVO<Storage>> pageQuery(StoragePageQueryDTO dto) {
        Page<Storage> page = new Page<>(dto.getPage(),dto.getPageSize());
        Page<Storage> pageRes = storageMapper.selectPage(page, new QueryWrapper<Storage>().like(!StrUtil.isBlank(dto.getStorageName()),"name", dto.getStorageName()));
        CommonQueryPageVO<Storage> resVo = new CommonQueryPageVO<>();
        resVo.setList(pageRes.getRecords());
        resVo.setTotal(pageRes.getTotal());
        return Result.success(resVo);
    }
}
