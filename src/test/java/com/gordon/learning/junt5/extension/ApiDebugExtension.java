package com.gordon.learning.junt5.extension;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApiDebugExtension implements BeforeEachCallback, TestWatcher {

    private static final String STORE_KEY = "API_DEBUG_INFO";
    private static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create(ApiDebugExtension.class);

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        // 在每個測試開始前，於 Store 中開闢一個空間存放該測試專用的 Debug 物件
        context.getStore(NAMESPACE).put(STORE_KEY, new ApiDebugInfo());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        ApiDebugInfo info = context.getStore(NAMESPACE).get(STORE_KEY, ApiDebugInfo.class);
        if (info != null && info.url != null) {
            saveReport(context.getDisplayName(), info, cause);
        }
    }

    private void saveReport(String testName, ApiDebugInfo info, Throwable cause) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = String.format("DEBUG_%s_%s.txt", testName, timestamp);

        StringBuilder report = new StringBuilder();
        report.append("=== 測試失敗偵錯報告 ===\n");
        report.append("測試名稱: ").append(testName).append("\n");
        report.append("失敗原因: ").append(cause.getMessage()).append("\n\n");
        report.append("--- API 詳細資訊 ---\n");
        report.append("URL: [").append(info.method).append("] ").append(info.url).append("\n");
        report.append("Status: ").append(info.statusCode).append("\n");
        report.append("Response Body:\n").append(info.responseBody).append("\n");

        try {
            Files.write(Paths.get(fileName), report.toString().getBytes());
            System.err.println(">> [Debug資訊已存檔] " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param context
     * @return
     */
    public static ApiDebugInfo getInfo(ExtensionContext context) {
        return context.getStore(NAMESPACE).get(STORE_KEY, ApiDebugInfo.class);
    }
}
