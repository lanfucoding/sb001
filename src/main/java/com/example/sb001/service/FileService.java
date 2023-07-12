package com.example.sb001.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.sb001.model.FileCustom;

import com.example.sb001.model.FileSSO;
import com.example.sb001.model.RecycleFile;
import com.example.sb001.model.SummaryFile;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipOutputStream;

/**
* @author mxhc
* @description 针对表【file】的数据库操作Service
* @createDate 2023-07-06 12:04:23
*/
public interface FileService extends IService<FileSSO> {
    public boolean renameDirectory(HttpServletRequest request, String currentPath, String srcName, String destName);
    public void delDirectory(HttpServletRequest request, String currentPath, String[] directoryName) throws Exception;
    public static final String PREFIX = "WEB-INF" + java.io.File.separator + "file" + java.io.File.separator;

    public void addNewNameSpace(HttpServletRequest request, String namespace);

    public String getFileName(HttpServletRequest request, String fileName);

    public  List<FileCustom> listFile(String path);

    public void uploadFilePath(HttpServletRequest request, MultipartFile[] files, String currentPath) throws Exception;

    List<FileCustom> searchFile(HttpServletRequest request, String currentPath, String reg, String regType);

    public boolean addDirectory(HttpServletRequest request, String currentPath, String directoryName);

    File downPackage(HttpServletRequest request, String currentPath, String[] fileNames, String username) throws Exception;

    String packageZip(String[] sourcePath) throws Exception;

    void writeZos(File file, String basePath, ZipOutputStream zos) throws IOException;

    void deleteDownPackage(File downloadFile);

    SummaryFile summarylistFile(String webrootpath, int number);

    void copyDirectory(HttpServletRequest request, String currentPath, String[] directoryName, String targetdirectorypath) throws Exception;

    List<RecycleFile> recycleFiles(HttpServletRequest request) throws Exception;

    void revertDirectory(HttpServletRequest request, int[] fileId) throws IOException;

    void delAllRecycle(HttpServletRequest request) throws Exception;
}
