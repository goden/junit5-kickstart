package com.gordon.learning.junt5.condition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ApiOnlineCondition.class)
public class OrderProcessTest {

    @Test
    void testOrderCreation() {
        // 只有在ApiOnlinieCondition回傳enabled時，這裡才會執行
        System.out.println("Executing testOrderCreation");
    }

}
