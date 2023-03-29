package com.xiaozhi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozhi.entity.User;
import com.xiaozhi.mapper.UserMapper;
import com.xiaozhi.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author xiaozhi
 * @description
 * @create 2021-07-2021/7/15 21:40
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
