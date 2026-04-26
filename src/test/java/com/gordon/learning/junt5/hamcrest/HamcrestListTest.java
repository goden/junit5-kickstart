package com.gordon.learning.junt5.hamcrest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HamcrestListTest {

    private List<String> values;

    @BeforeEach
    public void setUp() {
        values = new ArrayList<>();
        values.add("Jordan");
        values.add("Pippen");
        values.add("Rodman");
    }

    @DisplayName("This case describes the general condition that how to verify without Hamcrest in normal way.")
    @Test
    void testWithoutHamcrest() {
        assertEquals(3, values.size());
        assertTrue(values.contains("Jordan") || values.contains("Pippen") || values.contains("Rodman"));
    }

    @DisplayName("This case describes the human being code style to verify after using Hamcrest.")
    @Test
    void testWithHamcrest() {
        assertThat(values, hasSize(3));
        assertThat(values,
                hasItem(anyOf(equalTo("Jordan"), equalTo("Pippen"), equalTo("Rodman"))));
    }


}
