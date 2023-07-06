package com.example.sb001.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sb001.model.File;
import com.example.sb001.service.FileService;
import com.example.sb001.mapper.FileMapper;
import org.springframework.stereotype.Service;

/**
* @author mxhc
* @description 针对表【file】的数据库操作Service实现
* @createDate 2023-07-06 12:04:23
*/
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File>
    implements FileService{

}




