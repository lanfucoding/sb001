package com.example.sb001.service.impl;

import cn.hutool.Hutool;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sb001.model.User;
import com.example.sb001.service.UserService;
import com.example.sb001.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author mxhc
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-07-06 12:04:23
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        User users = userMapper.selectOne(wrapper);
        if (users == null) {
            user.setPassword(DigestUtil.md5Hex(user.getPassword()));
            userMapper.insert(user);
        } else {
            return false;
        }
        return true;
    }
}




