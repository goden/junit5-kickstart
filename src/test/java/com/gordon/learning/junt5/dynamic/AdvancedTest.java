package com.gordon.learning.junt5.dynamic;

import com.gordon.learning.junt5.dynamic.processor.MyProcessor;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AdvancedTest {

    /**
     * Group the related dynamic tests.
     * @return
     */
    @TestFactory
    Stream<DynamicNode> dynamicTestsWithContainers() {
        return Stream.of("A", "B", "C")
                .map(letter -> DynamicContainer.dynamicContainer(
                        "Test for " + letter,
                        Stream.of(
                                DynamicTest.dynamicTest(
                                        "Test 1 for " + letter,
                                        () -> assertNotNull(letter)),
                                DynamicTest.dynamicTest(
                                        "Test 2 for " + letter,
                                        () -> assertFalse(letter.isEmpty())
                                )
                        )
                ));
    }

    @TestFactory
    Stream<DynamicNode> nestedDynamicTests() {
        return Stream.of(
                DynamicContainer.dynamicContainer(
                        "String Test",
                        Stream.of(
                            DynamicTest.dynamicTest(
                                    "Empty Test",
                                    () -> assertTrue("".isEmpty())
                            ),
                            DynamicTest.dynamicTest(
                                    "Non-emtpy Test",
                                    () -> assertFalse("hello".isEmpty())
                            )
                        )
                ),
                DynamicContainer.dynamicContainer(
                        "Number Test",
                        Stream.of(
                            DynamicTest.dynamicTest(
                                    "Positive Number",
                                    () -> assertTrue(5 > 4)
                            ),
                            DynamicTest.dynamicTest(
                                    "Negative Number",
                                    () -> assertTrue(-5 < 0)
                            )
                        )
                )
        );
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestOnSetup() {
        return Stream.of("data1", "data2", "data3")
                .map(data -> DynamicTest.dynamicTest(
                        "Processing " + data,
                        () -> {
                            // setup
                            MyProcessor processor = new MyProcessor();
                            processor.initialize();

                            // test
                            String result = processor.process(data);
                            assertNotNull(result);

                            // teardown
                            processor.cleanup();
                        }
                ));
    }

}
