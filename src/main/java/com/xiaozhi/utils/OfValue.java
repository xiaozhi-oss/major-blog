package com.xiaozhi.utils;

/**
 * @author xiaozhi
 * @description 关于值的工具类
 * @create 2021-07-2021/7/12 20:26
 */
public class OfValue {

    /**
     * 如果传来的值为null，那么就使用默认值
     * @param get 传入的值
     * @param l 默认值
     * @return
     */
    public static Long getOrDefault(Long get, Long l) {
        if (get == null) {
            return l;
        }
        return get;
    }

}
