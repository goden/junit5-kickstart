package com.gordon.learning.junt5.lifecycle;

import com.gordon.learning.junt5.extension.BenchmarkExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BenchmarkExtension.class)
public class LifeCycleTest {

    @BeforeAll
    static void setup() {
        System.out.println("Before All");
    }

    @AfterAll
    static void teardown() {
        System.out.println("After All");
    }

    @BeforeEach
    void doBeforeEach() {
        System.out.println("Before Each");
    }

    @AfterEach
    void doAfterEach() {
        System.out.println("After Each");
    }

    @Test
    void test1() {
        System.out.println("test1");
    }

    @Test
    void test2() {
        System.out.println("test2");
    }

}
