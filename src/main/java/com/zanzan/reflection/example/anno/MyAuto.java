package com.zanzan.reflection.example.anno;

import java.lang.annotation.*;

/**
 * @author zanpengxia
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MyAuto {

}
