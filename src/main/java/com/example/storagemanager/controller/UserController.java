package com.example.storagemanager.controller;


import com.example.storagemanager.common.Result;
import com.example.storagemanager.entity.User;
import com.example.storagemanager.entity.dto.UpdatePasswordDTO;
import com.example.storagemanager.entity.dto.UserPageQueryDTO;
import com.example.storagemanager.entity.vo.CommonQueryPageVO;
import com.example.storagemanager.service.UserService;
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
@RequestMapping("/user")
@Api(tags = "用户管理")
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping
    @ApiOperation("添加用户")
    public Result<User> addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除用户")
    public Result<String> deleteUser(@PathVariable Integer id){
        return userService.deleteUserById(id);
    }

    @PostMapping("/updatePassword")
    @ApiOperation("更新密码")
    public Result<String> updatePassword(@RequestBody UpdatePasswordDTO dto){
        return userService.updatePassword(dto);
    }

    @PostMapping("/list")
    @ApiOperation("获取用户列表")
    public Result<CommonQueryPageVO<User>> list(@RequestBody UserPageQueryDTO dto){
        return userService.pageQuery(dto);
    }

}

