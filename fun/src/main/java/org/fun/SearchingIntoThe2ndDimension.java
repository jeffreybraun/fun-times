package org.fun;

/**
 * Class contains routines to search for a value in a two-dimensional array.
 */
public class SearchingIntoThe2ndDimension {

    /**
     * Determines if the target value is located in the supplied matrix.
     *
     * @param matrix two-dimensional array
     * @param target value to locate
     * @return true if target is found in the matrix, false if not found
     */
    public static boolean searchMatrix(int[][] matrix, int target) {

        int row = determineRow(matrix, target);
        if (row == -1)
            return false;

        int left = 0;
        int right = matrix[0].length - 1;
        while (left <= right) {
            int mid = ((right - left) / 2) + left;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    /**
     * Determines the row the target value is located in.
     *
     * @param matrix two-dimensional array
     * @param target value to locate
     * @return the row position of the target value, -1 if does not exist in the matrix
     */
    static int determineRow(int[][] matrix, int target) {
        int result = -1;

        int up = 0;
        int down = matrix.length - 1;
        int rowsEnd = matrix[0].length - 1;

        while (up <= down) {
            int midHeight = ((down - up) / 2) + up;
            if ((matrix[midHeight][0] <= target) && (matrix[midHeight][rowsEnd] >= target)) {
                result = midHeight;
                break;
            } else if (matrix[midHeight][0] > target) {
                down = midHeight - 1;
            } else {
                up = midHeight + 1;
            }
        }
        return result;
    }

}
