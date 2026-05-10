package com.gordon.learning.junt5.processor;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import java.lang.reflect.Field;

public class EnvInjectionPostProcessor implements TestInstancePostProcessor {
    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        // 取得測試類別中所有的欄位
        Field[] fields = testInstance.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(EnvValue.class)) {
                EnvValue annotation = field.getAnnotation(EnvValue.class);
                String key = annotation.value();

                // 模𢭠從系統或環境變數中取得設定
                String mockValue = "MOCK_VALUE_FOR_" + key;

                // 經反射映射機制將值注入到欄位中
                field.setAccessible(true);
                field.set(testInstance, mockValue);
            }
        }
    }
}
