package com.zanzan.reflection.example.service;

/**
 * @author huangfu
 */
public class EmailServiceImpl {

    public void senEmail(String userEmail){
        System.out.println(String.format("系统给【%s】发送邮件成功！",userEmail));
    }
}
