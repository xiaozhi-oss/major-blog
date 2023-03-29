package com.xiaozhi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xiaozhi.utils.BaseEntity;
import lombok.Data;

;

/**
 * @author xiaozhi
 * @description 博客标签类
 * @create 2021-07-2021/7/12 14:02
 */
@TableName("t_label")
@Data
public class Label extends BaseEntity {

    /**
     * 标签名
     */
    private String name;

    /**
     * 标签样式
     */
    private String style;   

}
