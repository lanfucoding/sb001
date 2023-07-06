package com.example.sb001.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName office
 */
@TableName(value ="office")
@Data
public class Office implements Serializable {
    /**
     * 
     */
    @TableId
    private String officemd5;

    /**
     * 
     */
    private String officeid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}