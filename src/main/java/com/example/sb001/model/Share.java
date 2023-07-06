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
    @TableId(type = IdType.AUTO)
    private Integer shareid;

    /**
     * 
     */
    private String shareurl;

    /**
     * 
     */
    private String path;

    /**
     * 
     */
    private String shareuser;

    /**
     * 1公开 2加密 -1已取消
     */
    private Integer status;

    /**
     * 提取码
     */
    private String command;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}