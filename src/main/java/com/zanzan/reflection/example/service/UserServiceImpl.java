package com.zanzan.reflection.example.service;

/**
 * 用户模块
 * @author huangfu
 */
public class UserServiceImpl {

    private EmailServiceImpl emailService;

    /**
     * 下订单
     * @param userEmail 用户邮箱
     */
    public void order(String userEmail){
        System.out.println("-------下单成功-------");
        System.out.println("-------查询用户-------");
        emailService.senEmail(userEmail);
    }
}
