package com.xiaozhi.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaozhi.entity.User;
import com.xiaozhi.service.UserService;
import com.xiaozhi.utils.MD5Util;
import com.xiaozhi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author xiaozhi
 * @description
 * @create 2021-07-2021/7/15 20:00
 */
@Controller
@RequestMapping("admin")
public class LoginController {
    private final String LOGIN = "admin/login";

    @Autowired
    UserService userService;

    @GetMapping("login")
    public String toLogin() {
        return LOGIN;
    }

    @ResponseBody
    @PostMapping("login")
    public Result login (User isUser,
                         @RequestParam String captcha,
                         @RequestParam boolean rememberMe,
                         HttpServletRequest request,
                         HttpServletResponse response) {
        HttpSession session = request.getSession();
        // 比对验证码
        if (!session.getAttribute("verifyCode").equals(captcha)) {
            return Result.fail().message("验证码错误，请重新输入");
        }
        if (isUser == null) {
            return Result.fail().message("请输入用户名和密码");
        }
        // 将用户密码进行加密
        isUser.setPassword(MD5Util.encrypt(isUser.getPassword()));
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", isUser.getUsername());
        // 验证用户名和密码是否一致
        wrapper.eq("password", isUser.getPassword());
        User user = userService.getOne(wrapper);
        if (user == null) {
            return Result.fail().message("登录失败，用户名或者密码错误");
        }
        session.setAttribute("user", user);
        // 设置cookie存活时间,一个月
        if (rememberMe) {
            session.setMaxInactiveInterval(3600 * 24 * 30);
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(3600 * 24 * 30);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
        }
        return Result.ok().message("登录成功");
    }


    // 注销
    @GetMapping("logout")
    public String logout(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            session.removeAttribute("user");
        }
        return LOGIN;
    }
}
