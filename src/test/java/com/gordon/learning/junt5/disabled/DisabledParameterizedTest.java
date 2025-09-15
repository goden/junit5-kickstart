package com.gordon.learning.junt5.disabled;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DisabledParameterizedTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void enabledParameterizedTest(int value) {
        Assertions.assertTrue(value > 0);
        System.out.println("Testing with value: " + value);
    }

    @Disabled("Parameterized test temporarily disabled")
    @ParameterizedTest
    @ValueSource(strings = {"apple", "banana", "orange"})
    void disabledParameterizedTest(String fruit) {
        System.out.println("This won't run: " + fruit);
        Assertions.assertNotNull(fruit);
    }

}
