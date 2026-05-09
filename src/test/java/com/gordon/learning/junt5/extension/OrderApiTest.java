package com.gordon.learning.junt5.extension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(ApiFailureSnapshotExtension.class)
public class OrderApiTest {
    @Test
    void testCreateOrder() {
        // 模擬 API 呼叫
        String response = "{ \"status\": \"error\", \"message\": \"Insufficient balance\" }";
        ApiFailureSnapshotExtension.lastApiResponse = response;

        // 假設斷言失敗（例如我們預期 status 是 success）
        assertTrue(response.contains("success"), "API 狀態應為成功");
    }
}
