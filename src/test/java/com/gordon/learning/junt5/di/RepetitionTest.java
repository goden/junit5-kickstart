package com.gordon.learning.junt5.di;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * RepetitionInfoParameterResolver, available in @RepeatedTest methods.
 */
public class RepetitionTest {

    @RepeatedTest(5)
    void testRepetitions(RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetition = repetitionInfo.getTotalRepetitions();

        System.out.println("The current repetition is " + currentRepetition + " of the " + totalRepetition);

        assertTrue(true);

    }

}
