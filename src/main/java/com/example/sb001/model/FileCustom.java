package com.example.sb001.model;

import lombok.Data;

@Data
public class FileCustom {
    private String fileName;
    private String fileType;
    private String fileSize;
    private String lastTime;
    private String filePath;
    private String currentPath;
}
