package com.xiaozhi.utils;

/**
 * @author xiaozhi
 * @description MD5加密工具类
 * @create 2021-07-2021/7/15 20:04
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 */
public class MD5Util {

    public static void main(String[] args) {
        System.out.println(encrypt("123"));
    }


    public static String encrypt(String strSrc) {
        try {
            char hexChars[] = { '0', 'z', '2', 'h', '4', 'i', '6', '7', '8',
                    '9', 'a', 'b', '3', 'd', 'e', 'f' };
            byte[] bytes = strSrc.getBytes();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bytes);
            bytes = md.digest();
            int j = bytes.length;
            char[] chars = new char[j * 2];
            int k = 0;
            for (int i = 0; i < bytes.length; i++) {
                byte b = bytes[i];
                chars[k++] = hexChars[b >>> 4 & 0xf];
                chars[k++] = hexChars[b & 0xf];
            }
            return new String(chars);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("MD5加密出错！！+" + e);
        }
    }
}
