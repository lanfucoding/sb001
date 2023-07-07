package com.example.sb001.service;

import com.example.sb001.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author mxhc
* @description 针对表【user】的数据库操作Service
* @createDate 2023-07-06 12:04:23
*/
public interface UserService extends IService<User> {

    boolean addUser(User user);

    User findOne(User user);
}
