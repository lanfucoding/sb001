package com.example.sb001.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName file
 */
@TableName(value ="file")
@Data

public class FileSSO implements Serializable {
    public FileSSO(String filepath) {
        this.filepath = filepath;
    }

    public FileSSO() {
    }
    /**
     * 
     */

    @TableId(type = IdType.AUTO)
    private Integer fileid;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String filepath;



    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}