package com.xiaozhi.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.crypto.provider.BlowfishKeyGenerator;
import com.xiaozhi.entity.Blog;
import com.xiaozhi.entity.Label;
import com.xiaozhi.service.BlogService;
import com.xiaozhi.service.LabelService;
import com.xiaozhi.utils.OfValue;
import jdk.nashorn.internal.ir.Labels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @author xiaozhi
 * @description
 * @create 2021-07-2021/7/12 12:44
 */
@Controller
@RequestMapping("/admin")
public class IndexController {

    private final String INDEX = "admin/index";

    @Autowired
    BlogService blogService;
    @Autowired
    LabelService labelService;

    @GetMapping({"/index","/"})
    public String index(Model model) {
        model.addAttribute("blog", blogService.count());
        model.addAttribute("label", labelService.count());
        return INDEX;
    }

}
