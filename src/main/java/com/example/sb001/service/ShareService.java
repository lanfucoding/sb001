package com.example.sb001.service;

import com.example.sb001.model.Share;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.sb001.model.ShareFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author mxhc
* @description 针对表【share】的数据库操作Service
* @createDate 2023-07-06 12:04:23
*/
public interface ShareService extends IService<Share> {

    String shareFile(HttpServletRequest request, String currentPath, String[] shareFile) throws Exception;

    List<ShareFile> findShare(HttpServletRequest request, String shareUrl) throws Exception;

    List<ShareFile> getShareFile(HttpServletRequest request, List<Share> shares);


    List<ShareFile> findShareByName(HttpServletRequest request, int status) throws Exception;

    String cancelShare(String url, String filePath, int status) throws Exception;
}
