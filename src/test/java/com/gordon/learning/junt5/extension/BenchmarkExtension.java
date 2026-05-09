package com.gordon.learning.junt5.extension;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * 自動記錄每個測試案例跑了多久，並在測試結束後把結果印出來
 */
public class BenchmarkExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private final String START_TIME = "Start time";

    @Override
    public void afterTestExecution(ExtensionContext context) {
        // 取得存入的時間
        long startTime = getStore(context).remove(START_TIME, long.class);
        long duration = System.currentTimeMillis() - startTime;

        // 印出測試結果
        System.out.printf(">> 測試 [%s] 耗時: %d 毫秒%n", context.getDisplayName(), duration);
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        // 在測試執行前，取得當前時間並存入 JUnit 的 Store（一個用來在生命週期傳遞資料的暫存區）
        getStore(context).put(START_TIME, System.currentTimeMillis());
    }

    // 輔助方法：取得 JUnit 提供給這個 Extension 專用的儲存空間
    private ExtensionContext.Store getStore(ExtensionContext context) {
        return context.getStore(ExtensionContext.Namespace.create(getClass(), context.getRequiredTestMethod()));
    }
}
