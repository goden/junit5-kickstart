package com.gordon.learning.junt5.extension;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ApiFailureSnapshotExtension implements TestWatcher {

    // 模擬一個存儲最後一次 API Response 的地方 (在實際專案中可能來自你的 BaseClient)
    public static String lastApiResponse = "";

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        String fileName = "failure_" + testName + "_" + System.currentTimeMillis() + ".json";

        try {
            // 將失敗時的 API 內容存檔
            Files.write(Paths.get(fileName), lastApiResponse.getBytes());
            System.err.println(">> 測試失敗！已將 API 回傳內容快照至: " + fileName);
        } catch (Exception e) {
            System.err.println("無法儲存快照檔案: " + e.getMessage());
        }
    }
}
