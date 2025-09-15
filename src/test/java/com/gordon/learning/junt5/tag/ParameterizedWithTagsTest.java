package com.gordon.learning.junt5.tag;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class ParameterizedWithTagsTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @Tag("parameterized")
    @Tag("math")
    void testSquareCalculation(int value) {
        int result = value * value;
        Assertions.assertTrue(result > 0);
        System.out.println("Square of " + value + " = " + result);
    }

    @RepeatedTest(3)
    @Tag("repeated")
    @Tag("stability")
    void testRepeatedExecution(RepetitionInfo repetitionInfo) {
        System.out.println("Repetition " + repetitionInfo.getCurrentRepetition() +
                " of " + repetitionInfo.getTotalRepetitions());
        Assertions.assertTrue(true);
    }

    @TestFactory
    @Tag("dynamic")
    @Tag("generated")
    Stream<DynamicTest> dynamicTestsWithTag() {
        return Stream.of(
                DynamicTest.dynamicTest("Dynamic Test 1",
                        () -> Assertions.assertEquals(4, 2 + 2)),
                DynamicTest.dynamicTest("Dynamic Test 2",
                        () -> Assertions.assertTrue(true))
        );
    }

}
