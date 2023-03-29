package com.xiaozhi.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaozhi.entity.Label;
import com.xiaozhi.service.LabelService;
import com.xiaozhi.utils.OfValue;
import com.xiaozhi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author xiaozhi
 * @description 标签类
 * @create 2021-07-2021/7/12 14:11
 */
@Controller
@RequestMapping("admin/label")
public class LabelController {

    private final String LABEL = "admin/label";             // 标签管理页
    private final String LABEL_EDIT = "admin/label-edit";   // 标签编辑页

    @Autowired
    private LabelService labelService;

    @GetMapping()
    public String toLabel() {
        return LABEL;
    }

    // 初始化数据
    @ResponseBody
    @GetMapping("/data")
    public Result labelData(@RequestParam(required = false) Long page,
                            @RequestParam(required = false) Long limit) {
        page = OfValue.getOrDefault(page, 1L);
        limit = OfValue.getOrDefault(limit, 5L);
        // 1 创建page对象
        Page<Label> pages = new Page<>(page, limit);
        // 2 查询数据
        Page<Label> labels = labelService.page(pages);
        // 3 得到数据
        List<Label> list = labels.getRecords();
        long count = labels.getTotal();
        // 4 设置当前跳转页
        return Result.ok(list, count);
    }

    // 添加页面跳转
    @GetMapping("/edit")
    public String toAdd(@RequestParam String type,
                        @RequestParam(required = false) Long id,
                        Model model,
                        HttpServletRequest request) {
        if (type.equals("add")) {
            request.setAttribute("option", "add");
            return LABEL_EDIT;
        } else if (type.equals("update")) {
            request.setAttribute("option", "update");
            Label label = labelService.getById(id);
            model.addAttribute("label", label);
            return LABEL_EDIT;
        }
        return LABEL;
    }

    // 添加
    @PostMapping("/edit")
    public String editLabel(Label label, Model model,
                            @RequestParam String option) {

        // 1 判断数据库是否存在label
        if (label == null) {
            return LABEL_EDIT;
        }
        QueryWrapper<Label> wrapper = new QueryWrapper<>();
        if (option.equals("add")) {
            wrapper.eq("name", label.getName());
            if (labelService.getOne(wrapper, true) != null) {
                model.addAttribute("option", "add");
                model.addAttribute("label", label);
                model.addAttribute("msg", "数据库中已有此标签名");
                return LABEL_EDIT;
            }
            labelService.save(label);
            return "redirect:/" + LABEL;
        }
        wrapper.eq("name", label.getName());
        wrapper.eq("style", label.getStyle());
        labelService.update(label, wrapper);
        return "redirect:/" + LABEL;
    }

    @ResponseBody
    @GetMapping("/delete")
    public Result deleteLabel(@RequestParam Long id) {
        if (labelService.getById(id) == null) {
            return Result.fail();
        }
        labelService.removeById(id);
        return Result.ok();
    }
}
