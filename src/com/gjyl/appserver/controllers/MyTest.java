package com.gjyl.appserver.controllers;

import com.gjyl.appserver.pojo.Section;

import java.lang.reflect.Field;

/**
 * Created by LiD on 2017/4/24.
 */
public class MyTest {
    public static void main(String[] args) throws IllegalAccessException {
        Section section = new Section();
        section.setName("科室");
        section.setMemo("10");

        Class secCla=(Class)section.getClass();
        Field[] fields = secCla.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);

            System.out.println(f.getName()+"\t"+f.get(section)+"\t"+f.getType());
        }

    }
}
