package com.zanzan.reflection.teaching.test;

import com.zanzan.reflection.teaching.ann.MyAnnotationField;
import com.zanzan.reflection.teaching.ann.MyAnnotationMethod;

public class ZanZanRefService {

    private String msg;

    @MyAnnotationField(myName = "张三")
    private String name;


    @MyAnnotationMethod
    public String printMsg(String msg) {
        System.out.println(msg);
        return msg;
    }

    public void senEmail(String msg){
        System.out.println("-----------------");
    }
}
