package com.gordon.learning.junt5.disabled;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.LocalDate;

public class ConditionalDisabledTest {
    @Test
    @DisabledOnOs(OS.WINDOWS)
    void testDisabledOnWindows() {
        System.out.println("This test won't run on Windows");
        Assertions.assertTrue(true);
    }

    @Test
    @DisabledOnOs({OS.LINUX, OS.MAC})
    void testDisabledOnUnixSystems() {
        System.out.println("This test only runs on Windows");
        Assertions.assertTrue(true);
    }

    // Disable based on Java version
    @Test
    @DisabledOnJre(JRE.JAVA_8)
    void testDisabledOnJava8() {
        System.out.println("This test won't run on Java 8");
        Assertions.assertTrue(true);
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_11)
    void testDisabledForJavaRange() {
        System.out.println("This test won't run on Java 8 through 11");
        Assertions.assertTrue(true);
    }

    // Disable based on system properties
    @Test
    @DisabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
    void testDisabledOn32BitArchitecture() {
        System.out.println("This test won't run on 32-bit systems");
        Assertions.assertTrue(true);
    }

    // Disable based on environment variables
    @Test
    @DisabledIfEnvironmentVariable(named = "CI", matches = "true")
    void testDisabledInCIPipeline() {
        System.out.println("This test won't run in CI environment");
        Assertions.assertTrue(true);
    }

    // Custom condition using @DisabledIf
    @Test
    @DisabledIf("customCondition")
    void testDisabledByCustomCondition() {
        System.out.println("This test is conditionally disabled");
        Assertions.assertTrue(true);
    }

    boolean customCondition() {
        // Custom logic to determine if test should be disabled
        return LocalDate.now().getDayOfWeek().getValue() == 1; // Disabled on Mondays
    }
}
