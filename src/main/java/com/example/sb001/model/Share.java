package com.example.sb001.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName share
 */
@TableName(value ="share")
@Data
public class Share implements Serializable {
    /**
     * 
     */
    public static final int PUBLIC = 1;
    public static final int PRIVATE = 2;
    public static final int CANCEL = 0;
    public static final int DELETE = -1;
    @TableId(type = IdType.AUTO)
    private Integer shareId;

    private String shareUrl;

    private String path;

    private String shareUser;

    private Integer status;

    private String command;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}