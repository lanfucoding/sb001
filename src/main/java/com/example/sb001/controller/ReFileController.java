package com.example.sb001.controller;

import com.example.sb001.model.FileCustom;
import com.example.sb001.model.RecycleFile;
import com.example.sb001.model.Result;
import com.example.sb001.model.SummaryFile;
import com.example.sb001.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static com.example.sb001.controller.UserController.pre;

@Controller
@RequestMapping("/file")
public class ReFileController {

    @Autowired
    FileService fileService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/file/getFiles")
    @ResponseBody
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

    @RequestMapping("/delAllRecycle")
    public @ResponseBody Result<String> delAllRecycleDirectory() {
        try {
            fileService.delAllRecycle(request);
            // 返回状态码
            return new Result<>(327, true, "删除成功");
        } catch (Exception e) {
            return new Result<>(322, false, "删除失败");
        }
    }


    @RequestMapping("/delDirectory")
    public @ResponseBody Result<String> delDirectory(String currentPath,String[] directoryName) {
        try {
            fileService.delDirectory(request, currentPath, directoryName);
            return new Result<>(346, true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(341, false, "删除失败");
        }
    }


    @RequestMapping("/renameDirectory")
    public @ResponseBody Result<String> renameDirectory(String currentPath,    String srcName, String destName) {
        try {
            fileService.renameDirectory(request, currentPath, srcName, destName);
            return new Result<>(356, true, "重命名成功");
        } catch (Exception e) {
            return new Result<>(351, false, "重命名失败");
        }
    }


    @RequestMapping("/summarylist")
    public String summarylist(Model model) {
        String webrootpath = fileService.getFileName(request, "");
        int number = webrootpath.length();
        SummaryFile rootlist = fileService.summarylistFile(webrootpath, number);
        model.addAttribute("rootlist", rootlist);
        return pre + "summarylist";
    }

    @RequestMapping("/copyDirectory")
    public @ResponseBody Result<String> copyDirectory(String currentPath,String[] directoryName, String targetdirectorypath) throws Exception {
        try {
            fileService.copyDirectory(request, currentPath, directoryName,
                    targetdirectorypath);
            return new Result<>(366, true, "复制成功");
        } catch (IOException e) {
            return new Result<>(361, true, "复制失败");
        }
    }

    @RequestMapping("/recycleFile")
    public String recycleFile() {
        try {
            List<RecycleFile> findDelFile = fileService.recycleFiles(request);
            if(null != findDelFile && findDelFile.size() != 0) {
                request.setAttribute("findDelFile", findDelFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pre + "recycle";
    }

    @RequestMapping("/revertDirectory")
    public @ResponseBody Result<String> revertDirectory(int[] fileId) {
        try {
            fileService.revertDirectory(request, fileId);
            return new Result<>(327, true, "还原成功");
        } catch (Exception e) {
            return new Result<>(322, false, "还原失败");
        }
    }
    @RequestMapping("/searchFile")
    public @ResponseBody Result<List<FileCustom>> searchFile(
            String currentPath, String regType, HttpServletRequest request, String reg) {
        try {
            List<FileCustom> searchFile = fileService.searchFile(request, currentPath, reg, regType);
            Result<List<FileCustom>> result = new Result<>(376, true, "查找成功");
            result.setData(searchFile);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(371, false, "查找失败");
        }
    }
    @ResponseBody
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