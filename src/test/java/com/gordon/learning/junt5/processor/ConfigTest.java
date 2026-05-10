package com.gordon.learning.junt5.processor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(EnvInjectionPostProcessor.class)
public class ConfigTest {

    @EnvValue("API_KEY")
    private String apiKey;

    @Test
    void testApiKeyInjection() {
        System.out.println("注入的 API Key 為: " + apiKey);
        assertNotNull(apiKey);
    }

}
