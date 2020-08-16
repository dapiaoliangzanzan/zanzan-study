package com.zanzan.reflection.example;

import com.zanzan.reflection.example.service.UserServiceImpl;
import com.zanzan.reflection.example.utils.BeanUtil;

public class TestMail {
    public static void main(String[] args) {
        Object bean = BeanUtil.getBean(UserServiceImpl.class);
        UserServiceImpl userService = (UserServiceImpl) bean;
        userService.order("1515@qq.com`");

    }
}
