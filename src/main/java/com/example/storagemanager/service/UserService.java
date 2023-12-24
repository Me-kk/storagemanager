package com.example.storagemanager.service;

import com.example.storagemanager.common.Result;
import com.example.storagemanager.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.storagemanager.entity.dto.UpdatePasswordDTO;
import com.example.storagemanager.entity.dto.UserPageQueryDTO;
import com.example.storagemanager.entity.vo.CommonQueryPageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guopei
 * @since 2023-12-19
 */
public interface UserService extends IService<User> {

    Result<User> addUser(User user);

    Result<String> deleteUserById(Integer id);

    Result<String> updatePassword(UpdatePasswordDTO dto);

    Result<CommonQueryPageVO<User>> pageQuery(UserPageQueryDTO dto);
}
