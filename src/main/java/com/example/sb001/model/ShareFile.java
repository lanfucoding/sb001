package com.example.sb001.model;

import lombok.Data;

@Data
public class ShareFile extends FileCustom {
    private String shareUser;
    private String url;
    //省略get/set方法
}
