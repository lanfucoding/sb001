package com.example.sb001.model;

import lombok.Data;

import java.util.List;
@Data

public class SummaryFile {
    private boolean isFile;//是不是一个文件
    private String path;//文件路径
    private String fileName;//文件名称
    private int listdiretory;//目录
    private List<SummaryFile> listFile;//文件
    //省略get/set方法
}