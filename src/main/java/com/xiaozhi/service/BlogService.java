package com.xiaozhi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozhi.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiaozhi
 * @description
 * @create 2021-07-2021/7/13 12:58
 */
public interface BlogService extends IService<Blog> {

   List<Blog> getBlogData(Long page, Long limit);

}
