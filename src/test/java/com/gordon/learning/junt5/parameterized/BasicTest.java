package com.gordon.learning.junt5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class BasicTest {

    @ParameterizedTest
    @ValueSource(strings = {"hello", "world", "junit"})
    void testWithStringParameter(String word) {
        assertFalse(word.isEmpty());
        assertTrue(word.length() > 2);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 8})
    void testWithInts(int number) {
        assertTrue(number > 0);
    }

}
