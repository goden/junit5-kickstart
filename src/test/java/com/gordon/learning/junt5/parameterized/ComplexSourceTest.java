package com.gordon.learning.junt5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComplexSourceTest {

    @ParameterizedTest
    @MethodSource("userProvider")
    void testUsers(User user, boolean isValid) {
        assertEquals(isValid, user.isValid());
    }

    static Stream<Arguments> userProvider() {
        return Stream.of(
                Arguments.of(new User("john", 25), true),
                Arguments.of(new User("", 25), false)
        );
    }

    static class User {

        String name;
        int age = 0;

        User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        boolean isValid() {
            return true;
        }
    }

}
