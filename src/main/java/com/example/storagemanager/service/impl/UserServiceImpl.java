package com.example.storagemanager.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.storagemanager.common.Result;
import com.example.storagemanager.entity.Provider;
import com.example.storagemanager.entity.User;
import com.example.storagemanager.entity.dto.UpdatePasswordDTO;
import com.example.storagemanager.entity.dto.UserPageQueryDTO;
import com.example.storagemanager.entity.vo.CommonQueryPageVO;
import com.example.storagemanager.entity.vo.ProviderPageQueryVO;
import com.example.storagemanager.mapper.UserMapper;
import com.example.storagemanager.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Result<User> addUser(User user) {
        if (user == null || StrUtil.isBlank(user.getUsername()) || StrUtil.isBlank(user.getPassword())){
            return Result.fail("用户名或密码为空");
        }
        userMapper.insert(user);
        return Result.success(user);
    }

    @Override
    public Result<String> deleteUserById(Integer id) {
        baseMapper.deleteById(id);
        return Result.success("success");
    }

    @Override
    public Result<String> updatePassword(UpdatePasswordDTO dto) {
        if (dto == null || StrUtil.isBlank(dto.getNewPassword()) || StrUtil.isBlank(dto.getPassword()) || StrUtil.isBlank(dto.getUsername())){
            return Result.fail("关键参数为空");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",dto.getUsername()).eq("password",dto.getPassword());
        User user = baseMapper.selectOne(queryWrapper);
        if (user == null)
            return Result.fail("账户名或密码错误");
        user.setPassword(dto.getNewPassword());
        baseMapper.updateById(user);
        return Result.success("success");
    }

    @Override
    public Result<CommonQueryPageVO<User>> pageQuery(UserPageQueryDTO dto) {
        Page<User> page = new Page<>(dto.getPage(),dto.getPageSize());
        Page<User> pageRes = userMapper.selectPage(page, new QueryWrapper<User>().like(!StrUtil.isBlank(dto.getName()),"username", dto.getName()));
        CommonQueryPageVO<User> resVo = new CommonQueryPageVO<>();
        resVo.setList(pageRes.getRecords());
        resVo.setTotal(pageRes.getTotal());
        return Result.success(resVo);
    }
}
