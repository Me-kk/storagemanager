package com.example.storagemanager.mapper;

import com.example.storagemanager.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author guopei
 * @since 2023-12-19
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
