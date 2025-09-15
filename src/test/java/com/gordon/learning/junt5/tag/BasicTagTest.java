package com.gordon.learning.junt5.tag;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class BasicTagTest {

    @Test
    @Tag("unit")
    void basicUnitTest() {
        int result = 2 + 2;
        Assertions.assertEquals(4, result);
        System.out.println("Running unit test");
    }

    @Test
    @Tag("integration")
    void integrationTest() {
        // Simulate integration test
        System.out.println("Running integration test");
        Assertions.assertTrue(true);
    }

    @Test
    @Tag("slow")
    @Tag("integration")
    void slowIntegrationTest() {
        // Simulate slow test
        System.out.println("Running slow integration test");
        Assertions.assertTimeout(Duration.ofSeconds(5), () -> Thread.sleep(1000));
    }


}
