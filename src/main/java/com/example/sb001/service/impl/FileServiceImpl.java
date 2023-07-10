package com.example.sb001.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sb001.mapper.FileMapper;
import com.example.sb001.model.FileCustom;
import com.example.sb001.model.FileSSO;
import com.example.sb001.model.User;
import com.example.sb001.service.FileService;
import com.example.sb001.utils.FileUtils;
import com.example.sb001.utils.UserUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * @author mxhc
 * @description 针对表【file】的数据库操作Service实现
 * @createDate 2023-07-06 12:04:23
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, FileSSO>
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

    @Override
    public List<FileCustom> searchFile(HttpServletRequest request, String currentPath, String reg, String regType) {
        List<FileCustom> list = new ArrayList<>();
        matchFile(request, list, new File(getSearchFileName(request, currentPath)), reg, regType == null ? "" : regType);
        return list;
    }




    private String getSearchFileName(HttpServletRequest request, String fileName) {
        if (fileName == null||fileName.equals("\\")) {
            System.out.println(1);
            fileName = "";
        }
        String username = UserUtils.getUsername(request);
        String realpath=getRootPath(request) + username + java.io.File.separator + fileName;
        return realpath;
    }

    private void matchFile(HttpServletRequest request, List<FileCustom> list,  File dirFile,
                           String reg,
                           String regType) {
       File[] listFiles = dirFile.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    String suffixType = FileUtils.getFileType(file);
                    if (suffixType.equals(regType) || (reg != null && file.getName().contains(reg))) {
                        FileCustom custom = new FileCustom();
                        custom.setFileName(file.getName());
                        custom.setLastTime(FileUtils.formatTime(file.lastModified()));
                        String parentPath = file.getParent();
                        String prePath = parentPath.substring(
                                parentPath.indexOf(getSearchFileName(request, null)) + getSearchFileName(request, null).length());
                        custom.setCurrentPath(java.io.File.separator + prePath);
                        if (file.isDirectory()) {
                            custom.setFileSize("-");
                        } else {
                            custom.setFileSize(FileUtils.getDataSize(file.length()));
                        }
                        custom.setFileType(FileUtils.getFileType(file));
                        list.add(custom);
                    }
                } else {
                    matchFile(request, list, file, reg, regType);
                }
            }
        }
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


    public boolean addDirectory(HttpServletRequest request, String currentPath, String directoryName) {
        File file = new File(getFileName(request, currentPath), directoryName);
        return file.mkdir();
    }

}




