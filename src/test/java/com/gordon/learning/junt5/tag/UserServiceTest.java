package com.gordon.learning.junt5.tag;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Class-level tags (inherited by all methods)
 */
@Tag("service")
@Tag("unit")
public class UserServiceTest {

    @Test
    void testCreateUser() {
        System.out.println("Testing user creation - inherits 'service' and 'unit' tags");
        Assertions.assertTrue(true);
    }

    @Test
    @Tag("database")  // This test has 'service', 'unit', and 'database' tags
    void testPersistUser() {
        System.out.println("Testing user persistence");
        Assertions.assertTrue(true);
    }

    @Test
    @Tag("validation")
    void testValidateUser() {
        System.out.println("Testing user validation");
        Assertions.assertTrue(true);
    }
}
