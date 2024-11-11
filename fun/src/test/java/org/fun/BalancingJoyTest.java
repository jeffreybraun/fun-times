package org.fun;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BalancingJoyTest {

    private static final String SUCCESS_MESSAGE = "This string is balanced.";
    private static final String FAILURE_MESSAGE = "This string is not balanced.";

    static Stream<Arguments> isValidData() {
        return Stream.of(
                Arguments.of("(((", false, FAILURE_MESSAGE),
                Arguments.of(")))", false, FAILURE_MESSAGE),
                Arguments.of("", true, SUCCESS_MESSAGE),
                Arguments.of("Nothing to see here!", true, SUCCESS_MESSAGE),
                Arguments.of("()", true, SUCCESS_MESSAGE),
                Arguments.of("{}", true, SUCCESS_MESSAGE),
                Arguments.of("[]", true, SUCCESS_MESSAGE)
        );
    }

    @ParameterizedTest
    @MethodSource("isValidData")
    void testisValid(String source, boolean expected, String message) {
        assertEquals(expected, BalancingJoy.isValid(source), message);
    }

}
