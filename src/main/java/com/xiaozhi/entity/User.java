package com.xiaozhi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xiaozhi
 * @description
 * @create 2021-07-2021/7/15 19:56
 */
@Data
@TableName("t_user")
public class User implements Serializable {

    /*
        用户id
     */
    private Long id;
    /*
        用户名
     */
    private String username;
    /*
        用户密码
     */
    private String password;
    /*
        是否是禁用状态
     */
    private String active;

}
