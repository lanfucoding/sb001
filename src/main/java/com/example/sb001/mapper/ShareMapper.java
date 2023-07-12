package com.example.sb001.mapper;

import com.example.sb001.model.Share;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author mxhc
* @description 针对表【share】的数据库操作Mapper
* @createDate 2023-07-06 12:04:23
* @Entity com.example.sb001.model.Share
*/
public interface ShareMapper extends BaseMapper<Share> {

    void shareFile(Share share) throws Exception;
    List<Share> findShare(Share share) throws Exception;
    List<Share> findShareByName(@Param("username") String username, @Param("status")  int status) throws Exception;
    void cancelShare(@Param("url") String url, @Param("filePath")  String filePath, @Param("status") int status) throws Exception;
}




