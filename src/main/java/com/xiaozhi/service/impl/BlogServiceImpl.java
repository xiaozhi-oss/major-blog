package com.xiaozhi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.xiaozhi.entity.Blog;
import com.xiaozhi.entity.Label;
import com.xiaozhi.mapper.BlogMapper;
import com.xiaozhi.mapper.LabelMapper;
import com.xiaozhi.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaozhi
 * @description
 * @create 2021-07-2021/7/13 12:58
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    /**
     * 分页数据返回
     * @param current      // 当前页
     * @param limit     // 页记录
     * @return
     */
    @Override
    public List<Blog> getBlogData(Long current, Long limit) {
        // 当前页 - 1 * 页记录 = 数据库中的跳转页
        Long page = (current - 1) * limit;
        return baseMapper.getBlogData(page, limit);
    }
}
