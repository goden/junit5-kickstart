package com.gordon.learning.junt5.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.net.ConnectException;

@ExtendWith(NetworkExceptionHandler.class)
public class ExternalApiTest {

    @Test
    void testRemoteCall() throws Exception {
        // 模擬一個會噴出連線異常的動作
        throw new ConnectException("無法連線至 n8n 伺服器");
    }
}
