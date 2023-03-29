package com.xiaozhi.utils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaozhi
 * @description 公共类
 * @create 2021-07-2021/7/12 14:05
 */
@Data
public class BaseEntity implements Serializable{

        @TableId(type = IdType.AUTO)
        private Long id;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        @TableField("create_time")
        private Date createTime = new Date();

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        @TableField("update_time")
        private Date updateTime = new Date();

        // 不会在数据库中存在的字段
        @TableField(exist = false)
        private Map<String,Object> param = new HashMap<String,Object>();
}
