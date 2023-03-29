package com.xiaozhi.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author xiaozhi
 * @description cookie工具类
 * @create 2022-10-2022/10/10 18:02
 */
public class CookieUtil {

    public static String getValue(HttpServletRequest request, String cookieName) {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public static Cookie getCookie(String name, String value, int expiry) {
        Cookie cookie = new Cookie(name, value);
        cookie.setDomain("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(expiry);
        return cookie;
    }
}
