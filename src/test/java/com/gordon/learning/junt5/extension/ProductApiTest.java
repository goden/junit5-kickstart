package com.gordon.learning.junt5.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({ApiDebugExtension.class, ExtensionContextResolver.class})
public class ProductApiTest {

    @Test
    void testUpdateProductPrice(ExtensionContext context) {
        // 1. 模擬 API 呼叫
        ApiDebugInfo debugInfo = ApiDebugExtension.getInfo(context);
        debugInfo.url = "https://api.example.com/v1/products/123";
        debugInfo.method = "PATCH";

        // 假設這是 API 回傳的結果
        debugInfo.statusCode = 403;
        debugInfo.responseBody = "{ \"error\": \"Permission Denied\", \"trace_id\": \"req-999\" }";

        // 2. 進行斷言 (這裡會失敗)
        assertEquals(200, debugInfo.statusCode, "更新價格應該要成功");
    }
}
