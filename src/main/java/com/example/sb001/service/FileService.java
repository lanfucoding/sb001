package com.example.sb001.service;

import com.example.sb001.model.File;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author mxhc
* @description 针对表【file】的数据库操作Service
* @createDate 2023-07-06 12:04:23
*/
public interface FileService extends IService<File> {

    public void addNewNameSpace(HttpServletRequest request, String namespace);
}
