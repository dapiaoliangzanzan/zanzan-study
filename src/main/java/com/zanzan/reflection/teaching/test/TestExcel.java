package com.zanzan.reflection.teaching.test;

import com.zanzan.reflection.teaching.ann.MyAnnotationField;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author huangfu
 */
public class TestExcel {
    /**
     * 模拟的Excel的数据集
     */
    static List<Map<String,String>> excelDataList = new ArrayList<>(8);
    static {
        Map<String,String> excelData1 = new HashMap<>();
        excelData1.put("名称","皇甫科星");
        excelData1.put("班级","计算机网络技术");
        excelDataList.add(excelData1);


        Map<String,String> excelData2 = new HashMap<>();
        excelData2.put("名称","昝鹏霞");
        excelData2.put("班级","计算机应用技术");
        excelDataList.add(excelData2);

        Map<String,String> excelData3 = new HashMap<>();
        excelData3.put("名称","赵六");
        excelData3.put("班级","软件工程");
        excelDataList.add(excelData3);
    }


    /**
     * 构建一个集合
     * @return excel的实体对象
     */
    public List<ExcelEntity> buildExcelEntityList() throws IllegalAccessException {
        //new一个存放所有行的list
        List<ExcelEntity> excelEntities = new ArrayList<>(8);
        //遍历原始伪excel数据
        for (Map<String, String> map : excelDataList) {
            //获取每一行
            Set<Map.Entry<String, String>> entries = map.entrySet();
            //new ExcelEntity
            ExcelEntity excelEntity = new ExcelEntity();
            //遍历每一行数据
            for (Map.Entry<String, String> entry : entries) {
                //获取titile值
                String title = entry.getKey();
                //获取对应内容
                String value = entry.getValue();
                //匹配实体类字段属性
                matchAttribute(title, value, excelEntity);
            }
            excelEntities.add(excelEntity);
        }
        return excelEntities;
    }

    /**
     * 寻找对应的属性并赋值
     * @param title 头
     * @param value 和
     * @return
     */
    private void matchAttribute(String title, String value, ExcelEntity excelEntity) throws IllegalAccessException {
        //获取类对象
        Class<? extends ExcelEntity> aClass = excelEntity.getClass();
        //获取类对象中的所有属性
        Field[] declaredFields = aClass.getDeclaredFields();
        //遍历每一个属性
        for (int i = 0; i < declaredFields.length; i++) {
            //获取对应的属性值
            Field declaredField = declaredFields[i];
            //如果这个属性包含注解值
            if (declaredField.isAnnotationPresent(MyAnnotationField.class)) {
                //获取具体注解
                MyAnnotationField myAnnotationField = declaredField.getAnnotation(MyAnnotationField.class);
                //获取具体的注解值
                String titleAnn = myAnnotationField.myName();
                //数据匹配
                if(titleAnn.equals(title)) {
                    declaredField.setAccessible(true);
                    declaredField.set(excelEntity,value);
                }
            }
        }

    }

    public static void main(String[] args) throws IllegalAccessException {
        TestExcel testExcel = new TestExcel();
        testExcel.buildExcelEntityList();
    }
}
