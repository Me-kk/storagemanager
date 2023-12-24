package com.example.storagemanager.mapper;

import com.example.storagemanager.entity.Outstorage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.storagemanager.entity.dto.InOutStoragePageQueryDTO;
import com.example.storagemanager.entity.vo.InOutStorageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author guopei
 * @since 2023-12-19
 */
@Mapper
public interface OutstorageMapper extends BaseMapper<Outstorage> {

    List<InOutStorageVO> pageQuery(InOutStoragePageQueryDTO dto);
}
