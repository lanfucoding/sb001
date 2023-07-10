//package com.example.sb001.config;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//public class FileController {
//    @RequestMapping("/searchFile")
//    public @ResponseBody Result<List<FileCustom>> searchFile(
//            String currentPath, String regType) {
//        try {
//            List<FileCustom> searchFile = fileService.searchFile(request,
//                    currentPath, regType);
//            Result<List<FileCustom>> result = new Result<>(376, true, "查找成功");
//            result.setData(searchFile);
//            return result;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Result<>(371, false, "查找失败");
//        }
//    }
//}
