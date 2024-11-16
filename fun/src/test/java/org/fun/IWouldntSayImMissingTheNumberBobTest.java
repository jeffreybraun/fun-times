package org.fun;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IWouldntSayImMissingTheNumberBobTest {

    private static Stream<Arguments> dataMissingNumberRanges() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 2, 3, 5, 6}, 4),
                Arguments.of(new int[]{6, 5, 4, 3, 2, 1, 0}, 7),
                Arguments.of(new int[]{0}, 1),
                Arguments.of(new int[]{6, 5, 4, 3, 2, 1, 7}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("dataMissingNumberRanges")
    void testMissingNumberBinarySearch(int[] nums, int expected) {
        assertEquals(expected, IWouldntSayImMissingTheNumberBob.missingNumberBinarySearch(nums),
                "The value expected wasn't returned.");
    }

    @ParameterizedTest
    @MethodSource("dataMissingNumberRanges")
    void testMissingNumberParallel(int[] nums, int expected) {
        assertEquals(expected, IWouldntSayImMissingTheNumberBob.missingNumberParallel(nums),
                "The value expected wasn't returned.");
    }

    @ParameterizedTest
    @MethodSource("dataMissingNumberRanges")
    void testMissingNumberGaussSum(int[] nums, int expected) {
        assertEquals(expected, IWouldntSayImMissingTheNumberBob.missingNumberGaussSum(nums),
                "The value expected wasn't returned.");
    }

}
