package com.example.sb001.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sb001.model.Share;
import com.example.sb001.service.ShareService;
import com.example.sb001.mapper.ShareMapper;
import org.springframework.stereotype.Service;

/**
* @author mxhc
* @description 针对表【share】的数据库操作Service实现
* @createDate 2023-07-06 12:04:23
*/
@Service
public class ShareServiceImpl extends ServiceImpl<ShareMapper, Share>
    implements ShareService{

}




