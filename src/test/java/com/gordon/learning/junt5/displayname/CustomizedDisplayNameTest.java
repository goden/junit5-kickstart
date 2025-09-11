package com.gordon.learning.junt5.displayname;

import com.gordon.learning.Calculator;
import com.gordon.learning.junt5.displayname.generator.CustomizedDisplayNameGenerator;
import org.junit.jupiter.api.*;

@DisplayNameGeneration(CustomizedDisplayNameGenerator.class)
public class CustomizedDisplayNameTest {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    void testDivideByNonZero() {
        double result = calculator.divide(10, 2);
        Assertions.assertEquals(5, result);
    }

    @Test
    void calculateTotalPrice() {
        double price = 100.0;
        double tax = 0.1;
        double total = price * (1 + tax);
        Assertions.assertEquals(110.0, total);
    }

    @Test
    void validateEmailFormat() {
        String email = "test@example.com";
        Assertions.assertTrue(email.contains("@"));
    }

    @Nested
    class ValidationTests {

        @Test
        void checkPasswordStrength() {
            String password = "StrongP@ss123";
            Assertions.assertTrue(password.length() >= 8);
        }
    }
}
