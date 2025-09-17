package com.gordon.learning.junt5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CsvSourceTest {

    @ParameterizedTest
    @CsvSource({
            "1, First",
            "2, Second",
            "3, Third"
    })
    void testWithCsvSource(int id, String name) {
        assertTrue(id > 0);
        assertNotNull(name);
    }

    /**
     * Use @ParameterizedTest to do test by reading an outside csv file.
     * Use @CsvFileSource with resources attribute to locate the csv file path.
     * Declare the numLinesToSkip attribute to skip the lines when reading data.
     * @param input
     * @param expected
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testWithCsvFile(String input, String expected) {
        assertEquals(expected, processInput(input));
    }

    private String processInput(String input) {
        if (!input.isEmpty()) {
           if (input.equals("1")) {
               return "First";
           } else if (input.equals("2")) {
               return "Second";
           } else if (input.equals("3")) {
               return "Third";
           } else {
               return input;
           }
        }
        return input;
    }


}
