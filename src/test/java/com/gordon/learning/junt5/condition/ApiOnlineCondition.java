package com.gordon.learning.junt5.condition;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.net.HttpURLConnection;
import java.net.URL;

public class ApiOnlineCondition implements ExecutionCondition {

    private static final String API_URL = "https://api.example.com/health";

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {

        // below is the check logic
        if (isOnline(API_URL)) {
            return ConditionEvaluationResult.enabled("API ONLINE");
        }

        // 回傳 disabled，測試將會被跳過 (Skipped) 而非失敗 (Failed)
        return ConditionEvaluationResult.disabled("API OFFLINE");
    }

    private boolean isOnline(String urlString) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(2000); // 2秒超時
            return connection.getResponseCode() == 200;
        } catch (Exception e) {
            return false;
        }
    }
}
