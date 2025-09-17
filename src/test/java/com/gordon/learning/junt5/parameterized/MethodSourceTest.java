package com.gordon.learning.junt5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Use the static method to provide test arguments.
 */
public class MethodSourceTest {

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithMethodSource(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana", "cherry");
    }

}
