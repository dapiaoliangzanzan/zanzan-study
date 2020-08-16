package com.zanzan.reflection.teaching.ref;

import com.zanzan.reflection.teaching.ann.MyAnnotationField;
import com.zanzan.reflection.teaching.ann.MyAnnotationMethod;
import com.zanzan.reflection.teaching.test.ZanZanRefService;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestRef {
    public static void main(String[] args) throws Exception {
        //拿到类对象
        Class zanZanRefServiceClass = ZanZanRefService.class;

        Object o = setFieldName(zanZanRefServiceClass, MyAnnotationField.class);
        System.out.println(o);
    }

    public static Object setFieldName(Class classes, Class<? extends Annotation> annotationClass) throws IllegalAccessException, InstantiationException {
        //1.类对象
        //2.拿到类的对象
        Object target = classes.newInstance();
        //3.渠道所有的属性对象
        Field[] declaredFields = classes.getDeclaredFields();
        //寻找
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            boolean annotationPresent = declaredField.isAnnotationPresent(annotationClass);
            if(annotationPresent) {
                declaredField.setAccessible(true);
                MyAnnotationField annotation = (MyAnnotationField) declaredField.getAnnotation(annotationClass);
                String myName = annotation.myName();
                //4.set进去
                declaredField.set(target,myName);
            }
        }
        return target;

    }


    public static void runMethod(Class cless, Class<? extends Annotation> annotationClass, Object... args) throws Exception {
        //类的对象
        Object target = cless.newInstance();
        //拿到所有的方法
        Method[] declaredMethods = cless.getDeclaredMethods();
        //遍历每一个方法
        for (int i = 0; i < declaredMethods.length; i++) {
            //获得具体的方法对象
            Method declaredMethod = declaredMethods[i];
            //判断方法对象是否包含传入的注解
            boolean annotationPresent = declaredMethod.isAnnotationPresent(annotationClass);
            if(annotationPresent) {
                //反射执行方法  参数：1.类的对象   2.参数    返回值：方法的结果
                Object result = declaredMethod.invoke(target, args);
                System.out.println("反射结果:"+result);
            }
        }
    }
}
