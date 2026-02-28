package com.gordon.learning.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericVarargs {
    
    @SafeVarargs
    public static <T> List<T> asList(T... args) {
        List<T> result = new ArrayList<T>();
        Collections.addAll(result, args);
        return result;
    }

    public static void main(String[] args) {
        List<String> strings = asList("A");
        System.out.println(strings);

        strings = asList("A", "B", "D");
        System.out.println(strings);

        strings = asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(strings);

    }
}
