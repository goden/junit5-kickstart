package com.gordon.learning.junt5.displayname;

import com.gordon.learning.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Using built-in replaceUnderscore generator
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ReplaceUnderscoreDisplayNameTest {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @DisplayName(value = "A displayName annotation which is located at method level.")
    @Test
    void testAddBy2PositiveNumbers() {
        int actual = calculator.add(2, 6);
        assertEquals(8, actual);
    }

}
