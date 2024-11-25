package org.fun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LastTwoForTheRoadTest {

    private static Stream<Arguments> dataFibonacci() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(4, 3),
                Arguments.of(5, 5),
                Arguments.of(6, 8),
                Arguments.of(7, 13)
        );
    }

    @ParameterizedTest
    @MethodSource("dataFibonacci")
    void testFibonacciRecursion(int input, int expected) {
        assertEquals(expected, LastTwoForTheRoad.fibonacciRecursion(input));
    }

    @ParameterizedTest
    @MethodSource("dataFibonacci")
    void testFibonacciIteration(int input, int expected) {
        assertEquals(expected, LastTwoForTheRoad.fibonacciIteration(input));
    }

}
