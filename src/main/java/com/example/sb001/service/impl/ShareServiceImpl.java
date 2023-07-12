package com.example.sb001.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sb001.model.Share;
import com.example.sb001.model.ShareFile;
import com.example.sb001.model.User;
import com.example.sb001.service.FileService;
import com.example.sb001.service.ShareService;
import com.example.sb001.mapper.ShareMapper;
import com.example.sb001.utils.FileUtils;
import com.example.sb001.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
* @author mxhc
* @description 针对表【share】的数据库操作Service实现
* @createDate 2023-07-06 12:04:23
*/
@Service
public class ShareServiceImpl extends ServiceImpl<ShareMapper, Share>
    implements ShareService{

    @Autowired
    private ShareMapper shareMapper;

    @Override
    public String shareFile(HttpServletRequest request, String currentPath, String[] shareFile) throws Exception {
        String username = (String) request.getSession().getAttribute(User.NAMESPACE);
        String shareUrl = FileUtils.getUrl8();
        for (String file : shareFile) {
            Share share = new Share();
            share.setPath(currentPath + File.separator + file);
            share.setShareUser(username);
            share.setShareUrl(shareUrl);
            shareMapper.shareFile(share);
        }
        return shareUrl;
    }

    @Override
    public List<ShareFile> findShare(HttpServletRequest request, String shareUrl) throws Exception{
        Share share = new Share();
        share.setShareUrl(shareUrl);
        share.setStatus(Share.PUBLIC);
        List<Share> shares = shareMapper.findShare(share);
        return getShareFile(request, shares);
    }

    @Override
    public List<ShareFile> getShareFile(HttpServletRequest request, List<Share> shares){
        List<ShareFile> files = null;
        if(shares != null){
            files = new ArrayList<ShareFile>();
            String rootPath = request.getSession().getServletContext().getRealPath("/") + FileService.PREFIX;
            for (Share share : shares) {
                File file = new File(rootPath + share.getShareUser(), share.getPath());
                ShareFile shareFile = new ShareFile();
                shareFile.setFileType(FileUtils.getFileType(file));
                shareFile.setFileName(file.getName());
                shareFile.setFileSize(file.isFile() ? FileUtils.getDataSize(file.length()) : "-");
                shareFile.setLastTime(FileUtils.formatTime(file.lastModified()));
                shareFile.setShareUser(share.getShareUser());
                shareFile.setUrl(share.getShareUrl());
                shareFile.setFilePath(share.getPath());
                files.add(shareFile);
            }
        }
        return files;
    }


   @Override
    public List<ShareFile> findShareByName(HttpServletRequest request, int status) throws Exception{
        List<Share> shares = shareMapper.findShareByName(UserUtils.getUsername(request), status);
        return getShareFile(request, shares);
    }

    @Override
    public String cancelShare(String url, String filePath, int status) throws Exception {
        if(Share.CANCEL == status){
            shareMapper.cancelShare(url, filePath, Share.DELETE);
            return "删除成功";
        }else{
            shareMapper.cancelShare(url, filePath, Share.CANCEL);
            return "链接已失效";
        }
    }
}




