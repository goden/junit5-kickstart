package com.gordon.learning.junt5.di;

import com.gordon.learning.Calculator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestReporter;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * RepetitionInfoParameterResolver, available in @RepeatedTest methods.
 */
public class RepetitionTest {

    private static final Set<Integer> integerSet = new HashSet<>();
    private static final List<Integer> integerList = new ArrayList<>();

    /**
     * basic usage
     * RepetitionInfo is an explicit injection.
     */
    @RepeatedTest(5)
    void testRepetitions(RepetitionInfo info) {

        int currentRepetition = info.getCurrentRepetition();
        int totalRepetition = info.getTotalRepetitions();

        System.out.println("The current repetition is " + currentRepetition + " of the " + totalRepetition);

        assertTrue(true);

    }

    @RepeatedTest(value = 5, name = "{displayName} - repetition {currentRepetition}/{totalRepetitions}")
    void testAddNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1),  "1 + 1 should be 2!");
    }

    @RepeatedTest(value = 5, name = "The list contains {currentRepetition} elements, the set contains 1 element.")
    void testAddCollections(TestReporter reporter, RepetitionInfo info) {
        integerSet.add(1);
        integerList.add(info.getCurrentRepetition());

        reporter.publishEntry("Repetition number", String.valueOf(info.getCurrentRepetition()));
        assertEquals(1, integerSet.size());
        assertEquals(info.getCurrentRepetition(), integerList.size());

    }



}
