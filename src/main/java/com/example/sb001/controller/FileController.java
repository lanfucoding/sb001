package com.example.sb001.controller;

import com.example.sb001.model.FileCustom;
import com.example.sb001.model.Result;
import com.example.sb001.service.FileService;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user/file")
public class FileController {



    @Autowired
    FileService fileService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/getFiles")
    public Result<List<FileCustom>> getFiles(HttpServletRequest request,String path) {
        //根据项目路径及用户名、文件名获取上传文件的真实路径
        String realPath = fileService.getFileName(request, path);
        //获取路径下所有的文件信息
        List<FileCustom> listFile = fileService.listFile(realPath);
        //将文件信息封装成Json对象
        Result<List<FileCustom>> result = new Result<List<FileCustom>>(325,
                true, "获取成功");
        result.setData(listFile);
        return result;
    }

    @RequestMapping("/searchFile")
    public @ResponseBody Result<List<FileCustom>> searchFile(
            String currentPath, String regType, HttpServletRequest request) {
        try {
            List<FileCustom> searchFile = fileService.searchFile(request, currentPath, regType, regType);
            Result<List<FileCustom>> result = new Result<>(376, true, "查找成功");
            result.setData(searchFile);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(371, false, "查找失败");
        }
    }

    @RequestMapping("/addDirectory")
    public  Result<String> addDirectory(String currentPath, String directoryName, HttpServletRequest request) {
        try {
            fileService.addDirectory(request, currentPath, directoryName);
            return new Result<>(336, true, "添加成功");
        } catch (Exception e) {
            return new Result<>(331, false, "添加失败");
        }
    }

    @RequestMapping("/upload")
    public @ResponseBody Result<String> upload(
            @RequestParam("files") MultipartFile[] files, String currentPath) {
        try {
            fileService.uploadFilePath(request, files, currentPath);
        } catch (Exception e) {
            return new Result<>(301, false, "上传失败");
        }
        return new Result<String>(305, true, "上传成功");
    }
}