package com.gordon.learning.junt5.di;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * TestReporterParameterResolver: Injects TestReporter for publishing test data:
 */
public class TestReporterTest {

    @Test
    void testWithReporter(TestReporter testReporter) {
        testReporter.publishEntry("status", "operating");
        assertTrue(true);
    }


}
