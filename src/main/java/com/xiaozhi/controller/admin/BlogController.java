package com.xiaozhi.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaozhi.entity.Blog;
import com.xiaozhi.entity.Label;
import com.xiaozhi.entity.vo.BlogVo;
import com.xiaozhi.mapper.BlogMapper;
import com.xiaozhi.service.BlogService;
import com.xiaozhi.service.LabelService;
import com.xiaozhi.utils.OfValue;
import com.xiaozhi.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xiaozhi
 * @description
 * @create 2021-07-2021/7/12 12:50
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogController {


    private final String BLOG_DETAILS = "admin/blog-details";
    private final String BLOG = "admin/blog";
    private final String BLOG_EDIT = "admin/blog-edit";

    @Autowired
    private BlogService blogService;
    @Autowired
    private LabelService labelService;

    // 跳转到blog管理页
    @GetMapping()
    public String blog() {
        return BLOG_DETAILS;
    }

    // 加载初始化数据
    @GetMapping("data")
    @ResponseBody
    public Result blogData(@RequestParam(required = false) Long page,
                           @RequestParam(required = false) Long limit) {
        // 获取当前页和单页数，然后进行判断
        page = OfValue.getOrDefault(page, 1L);
        limit = OfValue.getOrDefault(limit, 12L);
        // 调用方法查询数据
        Page<Blog> pageO = new Page<>(page, limit);
        Page<Blog> blogPage = blogService.page(pageO);
        // 将blog转换成blogVo
        List<Blog> blogs = blogPage.getRecords();
        List<BlogVo> list = new ArrayList<>();
        blogs.stream().forEach(blog -> {
            BlogVo blogVo = new BlogVo();
            BeanUtils.copyProperties(blog, blogVo);
            list.add(blogVo);
        });
        //System.out.println(blogs);
        return Result.ok(list,  new Long(blogService.count()));
    }


    // 更新功能的开启和关闭
    @ResponseBody
    @GetMapping("/option")
    public Result option(@RequestParam Long id,
                         @RequestParam String option,
                         @RequestParam String type) {
        Blog blog = blogService.getById(id);
        if (blog != null) {
            if (type.equals("on") || type.equals("off")) {
                // 修改功能开关
                updateFunction(blog, option, type);
                return Result.ok().message("修改成功");
            }
        }
        return Result.fail().message("修改失败");
    }

    // 更新功能开启状态
    private void updateFunction(Blog blog, String option, String type) {
        switch (option) {
            case "release":
                // 设置发布时间
                blog.setReleaseTime(new Date());
                blog.setIsRelease(type);
                break;
            case "recommend":
                blog.setRecommend(type);
                break;
            case "reprint":
                blog.setReprint(type);
                break;
            case "appreciate":
                blog.setAppreciate(type);
                break;
            case "comment":
                blog.setComment(type);
                break;
        }
        QueryWrapper<Blog> wrapper = new QueryWrapper<>();
        wrapper.eq("id", blog.getId());
        blogService.update(blog, wrapper);
    }


    @GetMapping("edit")
    public String toAddBlog(Model model,
                            @RequestParam(required = false) Long id) {
        // 通过判断id来判断是add还是update
        if (id == null) {
            // add
            List<Label> labels = labelService.list();
            model.addAttribute("labels", labels);
        } else {
            // update
            // 通过id查出数据
            Blog blog = blogService.getById(id);
            List<Label> labels = labelService.list();
            model.addAttribute("labels", labels);
            model.addAttribute("blog", blog);
        }
        return BLOG_EDIT;
    }

    @Autowired
    BlogMapper blogMapper;

    @PostMapping("save")
    public String saveBlog(Blog blog,
                           @RequestParam String option,
                           @RequestParam(required = false) Long bid) {
        if (blog != null) {
            if (bid == null) {
                if (option.equals("release")) {
                    // 保存数据
                    blog.setReleaseTime(new Date());
                    blog.setIsRelease("on");
                    blogService.save(blog);
                    return "redirect:/" + BLOG;
                } else if (option.equals("save")){
                    // 修改发布状态
                    blog.setIsRelease("off");
                    blogService.save(blog);
                    return "redirect:/" + BLOG;
                }
            } else {
                // 如果数据库中已经有这个id的数据了，就更新
                blog.setId(bid);
                // 如果为null就设置为off
                nullToOff(blog);
                if (option.equals("release")) {
                    // 设置发布状态为发布
                    blog.setIsRelease("on");
                }
                blogService.updateById(blog);
                return "redirect:/" + BLOG;
            }
        }
        return BLOG_EDIT;
    }

    private void nullToOff(Blog blog) {
        if (blog.getRecommend() == null) {
            blog.setRecommend("off");
        }
        if (blog.getAppreciate() == null) {
            blog.setAppreciate("off");
        }
        if (blog.getReprint() == null) {
            blog.setReprint("off");
        }
        if (blog.getComment() == null) {
            blog.setComment("off");
        }
    }


    // 删除操作
    @ResponseBody
    @GetMapping("/delete")
    public Result delete(@RequestParam Long id) {
        if (blogService.getById(id) != null) {
            blogService.removeById(id);
            return Result.ok().message("删除成功");
        }
        return Result.fail().message("删除失败");
    }
}
