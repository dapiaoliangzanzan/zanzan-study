package com.zanzan.reflection.teaching.ann;

import java.lang.annotation.*;

/**
 * @author huangfu
 */
@Documented
//你这个注解  再什么时候生效   RUNTIME:运行时生效，全部存在    SOURCE：源码中生效，编译之后不存在 运行时不存在    CLASS：只存在编译文件中  运行时不存在，源码不存在
@Retention(RetentionPolicy.RUNTIME)
//这个注解是加再什么类型上的   TYPE：加在类上    FIELD：加在属性上的   PARAMETER：加在方法参数上的  METHOD：加载方法上的   ANNOTATION_TYPE：注解上的
@Target(ElementType.METHOD)
public @interface MyAnnotationMethod {
}
