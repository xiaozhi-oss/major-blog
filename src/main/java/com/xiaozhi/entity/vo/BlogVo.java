package com.xiaozhi.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author xiaozhi
 * @description
 * @create 2021-07-2021/7/13 15:13
 */
@Data
public class BlogVo implements Serializable {

    private Long id;
    /**
     * 作者
     */
    private String author;
    /**
     * 作者
     */
    private String title;
    /**
     * 描述
     */
    private String blogDescribe;
    /**
     * 首图地址
     */
    private String imgUrl;
    /**
     * 标签名
     */
    private String label;
    /**
     * 博客类型
     */
    private String blogType;
    /**
     * 是否发布
     */
    private String isRelease;
    /**
     * 是否开启推荐功能
     */
    private String recommend;
    /**
     * 是否开启允许转载功能
     */
    private String reprint;
    /**
     * 是否开启赞赏功能
     */
    private String appreciate;
    /**
     * 是否开启评论功能
     */
    private String comment;
    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date releaseTime;
}
