package com.zanzan.reflection.example.utils;

import com.zanzan.reflection.example.anno.MyAuto;

import java.lang.reflect.Field;

public class BeanUtil {

    public static Object getBean(Class classes) throws IllegalAccessException, InstantiationException {
        //获取类对象
        Object o = classes.newInstance();
        //获取所有属性
        Field[] declaredFields = classes.getDeclaredFields();
        //
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            //判断该方法是否存在注解（只有存在注解的值才能被注入）
            if (declaredField.isAnnotationPresent(MyAuto.class)) {
                Class<?> type = declaredField.getType();
                Object o1 = type.newInstance();
                declaredField.setAccessible(true);
                declaredField.set(o,o1);
            }
        }
        return o;
    }
}
