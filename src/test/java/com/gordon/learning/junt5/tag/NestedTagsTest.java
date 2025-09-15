package com.gordon.learning.junt5.tag;

import org.junit.jupiter.api.*;

/**
 * Tags with nested test classes
 */
public class NestedTagsTest {

    @Nested
    @Tag("api")
    @DisplayName("API Tests")
    class ApiTests {

        @Test
        @Tag("v1")
        void testApiV1Endpoint() {
            System.out.println("Testing API v1");
            Assertions.assertTrue(true);
        }

        @Test
        @Tag("v2")
        @Tag("beta")
        void testApiV2Endpoint() {
            System.out.println("Testing API v2 (beta)");
            Assertions.assertTrue(true);
        }
    }

    @Nested
    @Tag("ui")
    @DisplayName("UI Tests")
    class UiTests {

        @Test
        @Tag("browser")
        @Tag("chrome")
        void testChromeCompatibility() {
            System.out.println("Testing Chrome UI");
            Assertions.assertTrue(true);
        }

        @Test
        @Tag("mobile")
        @Tag("responsive")
        void testMobileResponsiveness() {
            System.out.println("Testing mobile UI");
            Assertions.assertTrue(true);
        }
    }

}
