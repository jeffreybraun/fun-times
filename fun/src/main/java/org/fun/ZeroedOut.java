package org.fun;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Set Matrix Zeroes
 */
public class ZeroedOut {

    /**
     * Given a matrix, if an element is 0, set its entire row and column to 0's.
     *
     * @param matrix m x n integer matrix
     */
    public static void setZeroes(int[][] matrix) {

        Set<Integer> zeroRows = Collections.synchronizedSet(new HashSet<>());
        Set<Integer> zeroColumns = Collections.synchronizedSet(new HashSet<>());

        //rows and some columns
        IntStream.range(0, matrix.length).parallel().forEach(r -> {
            if (!zeroRows.contains(r)) {
                for (int c = 0; c < matrix[r].length; c++) {
                    if (matrix[r][c] == 0) {
                        zeroRows.add(r);
                        zeroColumns.add(c);
                    }
                }
            }
        });

        //column clean-up
        for (int[] ints : matrix) {
            IntStream.range(0, ints.length).parallel().forEach(c -> {
                if (!zeroColumns.contains(c)) {
                    if (ints[c] == 0) {
                        zeroColumns.add(c);
                    }
                }
            });
        }

        zeroRows.forEach(r -> {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[r][c] = 0;
            }
        });

        zeroColumns.forEach(c -> {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][c] = 0;
            }
        });

    }

}
