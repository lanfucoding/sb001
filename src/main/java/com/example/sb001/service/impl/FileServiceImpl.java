package com.example.sb001.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sb001.mapper.FileMapper;
import com.example.sb001.model.File;
import com.example.sb001.model.FileCustom;
import com.example.sb001.model.User;
import com.example.sb001.service.FileService;
import com.example.sb001.utils.UserUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * @author mxhc
 * @description 针对表【file】的数据库操作Service实现
 * @createDate 2023-07-06 12:04:23
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File>
        implements FileService{

    public static final String PREFIX = "WEB-INF" + java.io.File.separator + "file" + java.io.File.separator;

    //新用户注册默认文件夹
    public static final String[] DEFAULT_DIRECTORY = { "vido", "music", "source", "image", User.RECYCLE };
    public void addNewNameSpace(HttpServletRequest request, String namespace) {
        String fileName = getRootPath(request);
        java.io.File file = new java.io.File(fileName, namespace);
        file.mkdir();
        for (String newFileName : DEFAULT_DIRECTORY) {
            java.io.File newFile = new java.io.File(file, newFileName);
            newFile.mkdir();
        }
    }

    @Override
    public String getFileName(HttpServletRequest request, String fileName) {
        fileName= fileName.replace("\\", "//");
        if (fileName == null||fileName.equals("\\")) {
            System.out.println(1);
            fileName = "";
        }
        String username = UserUtils.getUsername(request);
        String realpath=getRootPath(request) + username + java.io.File.separator + fileName;
        return realpath;
    }

    @Override
    public List<FileCustom> listFile(String path) {
       return null;
    }

    public String getFileName(HttpServletRequest request, String fileName, String username) {
        if (username == null) {
            return getFileName(request, fileName);
        }
        if (fileName == null) {
            fileName = "";
        }
        return getRootPath(request) + username +  java.io.File.separator + fileName;
    }


    public String getRootPath(HttpServletRequest request) {
        String rootPath = request.getSession().getServletContext().getRealPath("/") + PREFIX;
        return rootPath;
    }

}




