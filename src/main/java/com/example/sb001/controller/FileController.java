package com.example.sb001.controller;

import com.example.sb001.model.FileCustom;
import com.example.sb001.model.Result;
import com.example.sb001.service.FileService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class FileController {

    FileService fileService;
    @RequestMapping("/getFiles")
    public @ResponseBody
    Result<List<FileCustom>> getFiles(HttpServletRequest request,String path) {
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
}