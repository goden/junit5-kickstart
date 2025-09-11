package com.gordon.learning.junt5.displayname.generator;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;
import java.util.List;

public class CustomizedDisplayNameGenerator extends DisplayNameGenerator.Standard {

    @Override
    public String generateDisplayNameForMethod(List<Class<?>> enclosingInstanceTypes, Class<?> testClass, Method testMethod) {
        String name = testMethod.getName();
        String displayName = name.replaceAll("([A-Z])", " $1").toLowerCase().trim();
        return "Method-Level:" + displayName;
    }

    @Override
    public String generateDisplayNameForNestedClass(List<Class<?>> enclosingInstanceTypes, Class<?> nestedClass) {
        return "Nested:"  + super.generateDisplayNameForNestedClass(enclosingInstanceTypes, nestedClass);
    }

    @Override
    public String generateDisplayNameForClass(Class<?> testClass) {
        return "Class-Level:" + super.generateDisplayNameForClass(testClass);
    }
}
