package com.gordon.learning.junt5.displayname;

import com.gordon.learning.Calculator;
import org.junit.jupiter.api.*;

/**
 * Using built-in IndicativeSentences generator
 */
@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
public class IndicatorDisplayNameTest {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    void testAdd2Integer() {
        int actual = calculator.add(2, 9);
        Assertions.assertEquals(11, actual);
    }

    @Nested
    class MyNestedTest {

        @Test
        void testSquareArea() {
            int actual = calculator.multiply(3, 5);
            Assertions.assertEquals(15, actual);
        }


    }

}
