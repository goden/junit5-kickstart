package com.gordon.learning.junt5.displayname;

import com.gordon.learning.Calculator;
import org.junit.jupiter.api.*;

/**
 * Using built-in Simple generator (removes "test" prefix and parentheses)
 */
@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
public class SimpleDisplayNameTest {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    void testAdd2Integers() {
        int actual = calculator.add(5, 7);
        Assertions.assertEquals(12, actual);
    }
}
