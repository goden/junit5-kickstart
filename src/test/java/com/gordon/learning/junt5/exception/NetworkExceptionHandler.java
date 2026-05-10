package com.gordon.learning.junt5.exception;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.net.ConnectException;

public class NetworkExceptionHandler implements TestExecutionExceptionHandler {
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        // 檢查異常是否為連線相關
        if (throwable instanceof ConnectException || throwable.getCause() instanceof ConnectException) {
            System.err.println(">> 偵測到網路連線失敗，跳過異常處理，測試將以『成功』結案 (但附帶警告)");
            // 只要不把 throwable 拋出去，JUnit 就會認為這個測試「通過」了
            return;
        }

        // 如果不是我們想處理的異常，就原封不動拋回去，讓測試正常失敗
        throw throwable;
    }
}
