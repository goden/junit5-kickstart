package com.gordon.learning.junt5.displayname;

import com.gordon.learning.Calculator;
import org.junit.jupiter.api.*;

/**
 * Using built-in Standard generator (default)
 */
@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
public class StandardDisplayNameTest {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @DisplayName(value = "A displayName annotation which is located at method level.")
    @Test
    void testAdd2MinusIntegers() {
        int actual = calculator.add(-3, -2);
        Assertions.assertEquals(-5, actual);
    }

}
