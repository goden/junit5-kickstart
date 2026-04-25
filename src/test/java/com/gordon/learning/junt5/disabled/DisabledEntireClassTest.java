package com.gordon.learning.junt5.disabled;

import org.junit.jupiter.api.*;

@Disabled("Each method in this class are disabled until the feature is complete.")
public class DisabledEntireClassTest {

    @Test
    void test1() {
        System.out.println("This won't run");
        Assertions.fail("Should be skipped");
    }

    @Test
    void test2() {
        System.out.println("This won't run either");
        Assertions.fail("Should be skipped");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Setup won't run for disabled class.");
    }

    @AfterEach
    void tearDown() {
        System.out.println("TearDown won't run for disabled class.");
    }

}
