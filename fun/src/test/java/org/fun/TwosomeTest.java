package org.fun;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TwosomeTest {

    static Stream<Arguments> TwoSumData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 5, new int[]{1, 2}),
                Arguments.of(new int[]{0, 2, 1, -3, 7}, 4, new int[]{3, 4}),
                Arguments.of(new int[]{1, 2}, 3, new int[]{0, 1}),
                Arguments.of(new int[]{1, 2, 1, 2}, 4, new int[]{1, 3}),
                Arguments.of(new int[]{}, 5, new int[]{0, 0}),
                Arguments.of(new int[]{3}, 0, new int[]{0, 0}),
                Arguments.of(new int[]{1701, 74656, 1031, 74205, 1764}, 3, new int[]{0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("TwoSumData")
    void test(int[] nums, int target, int[] expected) {
        var result = Twosome.twoSum(nums, target);
        assertEquals(result[0], expected[0], "The first value didn't match the expected.");
        assertEquals(result[1], expected[1], "The second value didn't match the expected.");
    }

}
