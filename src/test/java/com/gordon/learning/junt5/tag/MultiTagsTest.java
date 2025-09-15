package com.gordon.learning.junt5.tag;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class MultiTagsTest {

    @Test
    @Tag("fast")
    @Tag("unit")
    @Tag("core")
    void fastCoreUnitTest() {
        System.out.println("Fast core unit test");
        Assertions.assertTrue(true);
    }

    @Test
    @Tag("slow")
    @Tag("integration")
    @Tag("external")
    @Tag("database")
    void slowExternalDatabaseTest() {
        System.out.println("Slow external database test");
        Assertions.assertTrue(true);
    }

    @Test
    @Tag("regression")
    @Tag("critical")
    @Tag("customer-reported")
    void criticalRegressionTest() {
        System.out.println("Critical regression test for customer issue");
        Assertions.assertTrue(true);
    }
}
