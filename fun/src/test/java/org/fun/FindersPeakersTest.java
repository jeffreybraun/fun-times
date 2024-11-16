package org.fun;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FindersPeakersTest {

    static Stream<Arguments> dataPeaks() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, Set.of(2)),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 12, 9, 10, 11, 2}, Set.of(7, 10)),
                Arguments.of(new int[]{3}, Set.of(0)),
                Arguments.of(new int[]{}, Set.of(-1)),
                Arguments.of(new int[]{3, 1, 2}, Set.of(0, 2))
        );
    }

    @ParameterizedTest @MethodSource("dataPeaks") void testFindPeakElementInNTime(int[] nums, Set<Integer> expected) {
        int result = FindersPeakers.findPeakElementInNTime(nums);
        assertTrue(expected.contains(result));
    }

    @ParameterizedTest @MethodSource("dataPeaks") void testFindPeakElementInLogNTime(int[] nums,
            Set<Integer> expected) {
        int result = FindersPeakers.findPeakElementInLogNTime(nums);
        assertTrue(expected.contains(result));
    }

}
