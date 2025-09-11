package com.gordon.learning.junt5.displayname;

import org.junit.jupiter.api.*;

/**
 * All methods whose name has underlines will be replaced with empty spaces.
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MixedDisplayNameTest {

    @Test
    void this_test_uses_the_generator() {
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("This test has a custom display name that overrides the generator")
    void this_test_has_explicit_name() {
        Assertions.assertTrue(true);
    }

}
