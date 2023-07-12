package com.example.sb001.mapper;

import com.example.sb001.model.Office;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author mxhc
* @description 针对表【office】的数据库操作Mapper
* @createDate 2023-07-06 12:04:23
* @Entity com.example.sb001.model.Office
*/
public interface OfficeMapper extends BaseMapper<Office> {

    void addOffice(@Param("officeId") String officeId, @Param("officeMd5") String officeMd5) throws Exception;

    String getOfficeId(String officeMd5) throws Exception;
}




