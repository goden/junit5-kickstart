package com.gordon.learning.junt5.disabled;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisabledTest {

    /**
     * Disable a single test.
     */
    @Test
    @Disabled
    void testTemporarilyDisabled() {
        System.out.println("This test will not run");
        Assertions.fail("This test should have been skipped");
    }

    /**
     * Disable a single test without method.
     */
    @Test
    @Disabled("Disabled until bug #123 is fixed")
    void testDisabledWithReason() {
        System.out.println("This test is disabled with a reason");
        Assertions.fail("Should not execute");
    }

    /**
     * The test will run normally.
     */
    @Test
    void testThatWillRun() {
        int result = 2 + 2;
        Assertions.assertEquals(4, result);
        System.out.println("This test runs normally");
    }

}
