package com.xiaozhi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiaozhi
 * @description
 * @create 2021-07-2021/7/16 11:37
 */
@Slf4j
@ControllerAdvice   // 全局异常处理
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)  // 标识这个方法是可以用来做异常处理的
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e) {
        // 输出异常信息
        log.error("Request URL ： {}， Exception : {} ", request.getRequestURL(), e);
        // 返回到错误页面
        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURL());    // 返回错误的URL
        mv.addObject("exception", e);   // 返回异常信息
        mv.setViewName("error/error");  // 跳转到error页面
        return mv;

    }
}
