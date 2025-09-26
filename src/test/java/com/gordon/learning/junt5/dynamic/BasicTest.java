package com.gordon.learning.junt5.dynamic;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BasicTest {

    @TestFactory
    Collection<DynamicTest> dynamicTests() {
        return Arrays.asList(
                DynamicTest.dynamicTest("First dynamic test", () -> assertTrue(true)),
                DynamicTest.dynamicTest("Second dynamic test", () -> assertEquals(2, 1 + 1))
        );
    }

    @TestFactory
    List<DynamicTest> dynamicTestsFromCollection() {
        List<String> inputData = Arrays.asList("hello", "world", "junit");

        return inputData.stream()
                .map(word -> DynamicTest.dynamicTest(
                        "Testing word: " + word,
                        () -> assertFalse(word.isEmpty())
                ))
                .collect(Collectors.toList());
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStream() {
        return IntStream.range(1, 6)
                .mapToObj(i -> DynamicTest.dynamicTest(
                        "Test number " + i,
                        () -> assertTrue(i > 0 && i < 10)
                ));
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromFile() throws IOException {
        return Files.lines(Paths.get("test-data.txt"))
                .map(line -> DynamicTest.dynamicTest(
                        "Testing line: " + line,
                        () -> assertFalse(line.trim().isEmpty())
                ));
    }

}
