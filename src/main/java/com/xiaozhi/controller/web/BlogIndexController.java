package com.xiaozhi.controller.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaozhi.entity.Blog;
import com.xiaozhi.entity.Label;
import com.xiaozhi.entity.vo.BlogVo;
import com.xiaozhi.service.BlogService;
import com.xiaozhi.service.LabelService;
import com.xiaozhi.utils.MarkdownUtil;
import com.xiaozhi.utils.OfValue;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaozhi
 * @description
 * @create 2021-07-2021/7/14 20:56
 */
@Controller
public class BlogIndexController {

    private final String INDEX = "index";
    private final String BLOG_DETAILS = "page/blog";

    @Autowired
    BlogService blogService;
    @Autowired
    LabelService labelService;

    @GetMapping({"/index","/"})
    public String index(@RequestParam(required = false) Long page,
                        @RequestParam(required = false) Long size,
                        @RequestParam(required = false) String label,
                        Model model) {
        page = OfValue.getOrDefault(page, 1L);
        size = OfValue.getOrDefault(size, 6L);
        // 1 获取label
        List<Label> labels = labelService.list();
        // 2 获取已经发布的博客
        // ① 创建page对象进行分页
        Page<Blog> blogPage = new Page<>(page, size);
        // ② 创建queryWrapper对象进行筛选
        QueryWrapper<Blog> wrapper = new QueryWrapper<>();
        // ③ 查询允许发布的文章
        wrapper.eq("is_release", "on");
        if (label != null && label.length() > 0) {
            model.addAttribute("label", label);
            wrapper.eq("label", label);
        }
        wrapper.orderByDesc("id");
        List<Blog> blogs = blogService.page(blogPage, wrapper).getRecords();
        List<BlogVo> list = new ArrayList<>();
        blogs.stream().forEach(blog -> {
            BlogVo blogVo = new BlogVo();
            BeanUtils.copyProperties(blog, blogVo);
            list.add(blogVo);
        });
        // 总记录数
        model.addAttribute("count", blogPage.getTotal());
        // 标签
        model.addAttribute("labels", labels);
        // 博客
        model.addAttribute("blogs", list);
        model.addAttribute("current", page);
        return INDEX;
    }

    // 博客详情
    @GetMapping("blog/details")
    public String details(@RequestParam Long id,
                          Model model) {

        // 根据id查找对应的博客
        Blog blog = blogService.getById(id);
        if (blog == null) {
            return INDEX;
        }
        // 得到markdown解析的文本
        String content = MarkdownUtil.markdownToHtmlExtensions(blog.getContent());
        blog.setContent(content);
        model.addAttribute("blog", blog);
        return BLOG_DETAILS;
    }
}
