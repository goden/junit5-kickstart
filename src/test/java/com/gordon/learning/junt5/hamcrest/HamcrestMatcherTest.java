package com.gordon.learning.junt5.hamcrest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatcherTest {

    private static String FIRST_NAME = "Gordan";
    private static String LAST_NAME = "Cheng";
    private Guest guest = new Guest(FIRST_NAME, LAST_NAME);

    @DisplayName("Hamcrest is, anyOf, allOf")
    @Test
    void testHamcrestIs() {
        int price1 = 100;
        int price2 = 50;
        assertThat(100, is(price1));
        assertThat(100, anyOf(is(price1), is(price2)));
        assertThat(50, allOf(is(price1), is(price2)));
    }

    @DisplayName("Null expected.")
    @Test
    void testNull() {
        assertThat(null, nullValue());
    }

    @DisplayName("Object expected.")
    @Test
    void testNotNull() {
        assertThat(guest, notNullValue());
    }

    @DisplayName("Check correct guest properties.")
    @Test
    void testCorrectGuestProperties() {
        assertThat(guest, allOf(
                hasProperty("first", is(FIRST_NAME)),
                hasProperty("last", is(LAST_NAME))));
    }

    public static class Guest {
        private String first;
        private String last;
        public Guest() {}
        public Guest(String first, String last) {
            this.first = first;
            this.last = last;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }
    }

}
