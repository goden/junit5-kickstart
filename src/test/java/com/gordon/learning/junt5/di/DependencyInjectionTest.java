package com.gordon.learning.junt5.di;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

public class DependencyInjectionTest {

    // constructor injection
    DependencyInjectionTest(TestInfo testInfo) {
        System.out.println("Test class: " + testInfo.getTestClass());
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        // Setup logic with injected TestInfo
    }

    @Test
    void testMethod(TestInfo testInfo, TestReporter reporter) {
        reporter.publishEntry("test", testInfo.getDisplayName());
        // Test logic
    }

}
