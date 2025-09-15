package com.gordon.learning.junt5.tag;

import com.gordon.learning.junt5.tag.annotation.FastUnitTest;
import com.gordon.learning.junt5.tag.annotation.SlowDatabaseTest;
import org.junit.jupiter.api.Assertions;

public class MyTagAnnotationTest {

    @FastUnitTest           // Equivalent to @Test @Tag("fast") @Tag("unit")
    void testWithMyAnnotation() {
        System.out.println("Fast unit test using custom annotation");
        Assertions.assertTrue(true);
    }

    @SlowDatabaseTest
    void testDatabaseWithMyAnnotation() {
        System.out.println("Slow database test using custom annotation");
        Assertions.assertTrue(true);
    }

}
