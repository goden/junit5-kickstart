package com.gordon.learning.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GenericMagic {

    public static void main(String[] args) {
        ArrayList<String> normalList = new ArrayList<>();
        ArrayList<String> fancyList = new ArrayList<String>(){};
        System.out.println(getGenericType(normalList.getClass()));
        System.out.println(getGenericType(fancyList.getClass()));
    }

    public static String getGenericType(Class<?> clazz) {
        Type superclass = clazz.getGenericSuperclass();
        if (superclass instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) superclass;
            return pType.getActualTypeArguments()[0].getTypeName();
        }
        return "未知 (已被擦除)";
    }
}
