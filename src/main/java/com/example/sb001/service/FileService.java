package com.example.sb001.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.sb001.model.FileCustom;

import com.example.sb001.model.FileSSO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
* @author mxhc
* @description 针对表【file】的数据库操作Service
* @createDate 2023-07-06 12:04:23
*/
public interface FileService extends IService<FileSSO> {

    public void addNewNameSpace(HttpServletRequest request, String namespace);

    public String getFileName(HttpServletRequest request, String fileName);

    public  List<FileCustom> listFile(String path);



    List<FileCustom> searchFile(HttpServletRequest request, String currentPath, String reg, String regType);

    public boolean addDirectory(HttpServletRequest request, String currentPath, String directoryName);

}
