package org.fun;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class tseTgnirtSesreveR {

    static Stream<Arguments> ReverseStringData() {
        return Stream.of(
                Arguments.of("tseTgnirtSesreveR", "ReverseStringTest"),
                Arguments.of("racecar", "racecar"),
                Arguments.of(null, null),
                Arguments.of("a", "a"),
                Arguments.of("", "")
        );
    }

    @ParameterizedTest
    @MethodSource("ReverseStringData")
    void testReverse(String input, String expected) {
        assertEquals(expected, gnirtSesreveR.esrever(input), "Expected output did not match what was expected.");
    }

    @ParameterizedTest
    @MethodSource("ReverseStringData")
    void testReverseSimple(String input, String expected) {
        assertEquals(expected, gnirtSesreveR.elpmiSesrever(input), "Expected output did not match what was expected.");
    }

}
