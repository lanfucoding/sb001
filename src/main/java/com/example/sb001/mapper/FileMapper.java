package com.example.sb001.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sb001.model.FileSSO;
import org.apache.ibatis.annotations.Mapper;


/**
* @author mxhc
* @description 针对表【file】的数据库操作Mapper
* @createDate 2023-07-06 12:04:23
* @Entity com.example.sb001.model.File
*/
public interface FileMapper extends BaseMapper<FileSSO> {


    void insertFile( String filename, String filePath);
}




