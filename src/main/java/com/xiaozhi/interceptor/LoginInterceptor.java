package com.xiaozhi.interceptor;

import com.xiaozhi.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author xiaozhi
 * @description 登录拦截器
 * @create 2021-07-2021/7/15 19:54
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 拦截登录，没有登录就跳转到登录页，登录了就放行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 跳转到登录页面，并提示
            request.setAttribute("msg", "请先登录");
            // 重定向到登录页面
            response.sendRedirect("/admin/login");
            return false;
        }
        return true;
    }
}
