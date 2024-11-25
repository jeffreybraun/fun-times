package org.fun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BetterTogetherTest {

    private static Stream<Arguments> dataMergeTwoArrays() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}, new int[]{}),
                Arguments.of(new int[]{}, new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{1}, new int[]{}, new int[]{1}),
                Arguments.of(new int[]{}, new int[]{2, 4, 6}, new int[]{2, 4, 6}),
                Arguments.of(new int[]{1, 3, 5}, new int[]{2, 4, 6}, new int[]{1, 2, 3, 4, 5, 6}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6})
        );
    }

    @ParameterizedTest
    @MethodSource("dataMergeTwoArrays")
    void testMergeSortedArrays(int[] num1, int[] num2, int[] expected) {
        int[] result = BetterTogether.mergeSortedArrays(num1, num2);
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

}
