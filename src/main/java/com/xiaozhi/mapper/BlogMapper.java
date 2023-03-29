package com.xiaozhi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaozhi.entity.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiaozhi
 * @description
 * @create 2021-07-2021/7/13 13:14
 */
@Repository
public interface BlogMapper extends BaseMapper<Blog> {

    /**
     * 得到博客数据
     * @param page
     * @param limit
     * @return
     */
    List<Blog> getBlogData(@Param("page") Long page, @Param("limit") Long limit);

}
