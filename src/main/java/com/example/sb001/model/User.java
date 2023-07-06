package com.example.sb001.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableId
    private String username;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String countsize;

    /**
     * 
     */
    private String totalsize;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}