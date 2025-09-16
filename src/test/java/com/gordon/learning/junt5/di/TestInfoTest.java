package com.gordon.learning.junt5.di;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Built-in Parameter Resolvers
 * TestInfoParameterResolver injects TestInfo objects containing metadata about the current test.
 */
public class TestInfoTest {

    TestInfoTest(TestInfo info) {
        assertEquals("TestInfoTest", info.getDisplayName());
    }

    @BeforeEach
    void setup(TestInfo info) {
        String displayName = info.getDisplayName();
        assertEquals("display name of the method", displayName);
    }

    @Test
    void testGetNameofTheMethod(TestInfo info) {
        assertEquals("testGetNameofTheMethod(TestInfo info)", info.getDisplayName());
    }

    @Test
    @DisplayName("display name of the method")
    void testGetNameofTheMethodWithDisplayNameAnnotation(TestInfo info) {
        assertEquals("testGetNameofTheMethod(TestInfo info)", info.getDisplayName());
    }

}
