package com.xiaozhi.utils;

import lombok.Getter;

/**
 * @author xiaozhi
 * @description 统一返回结果状态信息类
 * @create 2021-07-2021/7/12 15:17
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "成功"),
    FAIL(201, "失败"),
    PARAM_ERROR(202, "参数不正确"),
    SERVICE_ERROR(203, "服务异常"),
    DATA_ERROR(204, "数据异常"),
    DATA_UPDATE_ERROR(205, "数据版本异常"),

    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限"),

    CODE_ERROR(210, "验证码错误"),
    //    LOGIN_MOBLE_ERROR(211, "账号不正确"),
    LOGIN_DISABLED_ERROR(212, "改用户已被禁用"),
    REGISTER_MOBLE_ERROR(213, "手机号已被使用"),
    LOGIN_AURH(214, "需要登录"),
    LOGIN_ACL(215, "没有权限"),;

    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
