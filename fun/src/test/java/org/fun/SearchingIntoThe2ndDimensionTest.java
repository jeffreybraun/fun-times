package org.fun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchingIntoThe2ndDimensionTest {

    private static Stream<Arguments> dataMatrix() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3, true),
                Arguments.of(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 60, true),
                Arguments.of(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 1, true),
                Arguments.of(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 10, true),
                Arguments.of(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13, false)
        );
    }

    @ParameterizedTest
    @MethodSource("dataMatrix")
    void testSearchMatrix(int[][] matrix, int target, boolean expected) {
        assertEquals(expected, SearchingIntoThe2ndDimension.searchMatrix(matrix, target));
    }

}
