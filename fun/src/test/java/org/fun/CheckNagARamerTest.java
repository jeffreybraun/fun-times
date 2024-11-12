package org.fun;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CheckNagARamerTest {

    private static Stream<Arguments> dataAnagram() {
        return Stream.of(
                Arguments.of("Anagram", "A Arm Nag", true),
                Arguments.of("CheckNagARamer", "Anagram Checker", true),
                Arguments.of("Captain Kirk", "Captain Picard", false),
                Arguments.of("enterprise", "enterprise", true),
                Arguments.of("a", "A", true),
                Arguments.of("", "", true),
                Arguments.of("!A Bc D?;: Plo", "     Abcdp ol   !!!!!", true)
        );
    }

    @ParameterizedTest
    @MethodSource("dataAnagram")
    void testAreAnagrams(String a, String b, boolean expected) {
        assertEquals(expected, CheckNagARamer.areAnagrams(a, b));
    }

}
