package com.zanzan.reflection.teaching.test;

import com.zanzan.reflection.teaching.ann.MyAnnotationField;

/**
 * @author huangfu
 */
public class ExcelEntity {
    @MyAnnotationField(myName = "名称")
    private String name;

    @MyAnnotationField(myName = "班级")
    private String clazz;

    public ExcelEntity(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    public ExcelEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
