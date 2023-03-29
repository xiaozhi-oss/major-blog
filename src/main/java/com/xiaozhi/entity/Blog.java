package com.xiaozhi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.xiaozhi.utils.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiaozhi
 * @description
 * @create 2021-07-2021/7/13 12:59
 */
@TableName("t_blog")
@Data
public class Blog extends BaseEntity {

    private String author;          // 作者
    private String title;           // 标题
    private String blogDescribe;    // 描述
    private String content;         // 内容
    private String blogType;        // 博客类型：原创还是转载
    private String imgUrl;          // 首图地址
    private String isRelease;       // 是否发布
    private String recommend;       // 是否开启推荐功能
    private String reprint;         // 是否开启允许转载功能
    private String appreciate;      // 是否开启赞赏功能
    private String comment;         // 是否开启评论功能

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date releaseTime;       // 发布时间

    private String label;           // 标签

    public void setImgUrl(String imgUrl) {
        if (imgUrl.startsWith("http://") || imgUrl.startsWith("https://")) {
            this.imgUrl = imgUrl;
        } else if (imgUrl == "" || imgUrl == null) {
            this.imgUrl = "https://picsum.photos/id/10/170/120";
        } else {
            this.imgUrl = "https://picsum.photos/id/" + imgUrl + "/170/120";
        }

    }
}
