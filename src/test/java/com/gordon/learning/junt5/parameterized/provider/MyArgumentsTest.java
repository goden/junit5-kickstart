package com.gordon.learning.junt5.parameterized.provider;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyArgumentsTest {

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    void testWithCustomProvider(String input) {
        assertTrue(true);
        assertEquals("age1", input);
    }

}
