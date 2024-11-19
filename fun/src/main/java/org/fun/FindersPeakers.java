package org.fun;

/**
 * Finds a peak element in an array.
 * A peak element is an element that is greater than its neighbors.
 */
public class FindersPeakers {

    /**
     * Finds a peak element in an array, and returns it's index value.
     * A peak element is an element that is greater than its array neighbors.
     * Note: This routine does not deal with number plateaus.
     *
     * @param nums source data
     * @return Index position of peek element.
     */
    public static int findPeakElementInNTime(int... nums) {
        int result = -1;
        if (nums.length != 0) {
            int peak = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (peak > nums[i]) {
                    break;
                } else {
                    peak = nums[i];
                    result = i;
                }
            }
        }
        return result;
    }

    /**
     * Finds a peak element in an array, and returns it's index value.
     * A peak element is an element that is greater than its array neighbors.
     * Note: This routine does not deal with number plateaus.
     *
     * @param nums source data
     * @return Index position of peek element.
     */
    public static int findPeakElementInLogNTime(int... nums) {
        int result = -1;
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = calculateMiddleIndex(left, right);
            boolean leftSmaller = isLeftSmaller(mid, nums);
            boolean rightSmaller = isRightSmaller(mid, nums);
            if (leftSmaller && rightSmaller) {
                result = mid;
                break;
            } else if (leftSmaller || !rightSmaller) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return result;
    }

    /**
     * Calculates a middle value based on the left and right values.
     *
     * @param left  left value
     * @param right right value
     * @return integer middle value
     */
    private static int calculateMiddleIndex(int left, int right) {
        return ((right - left) / 2) + left;
    }

    /**
     * Determines if the num[index - 1] value is less than the num[index] value.
     *
     * @param index Index value to examine
     * @param nums  Array of ints
     * @return true if num[index - 1] is less than num[index], false if not.
     */
    private static boolean isLeftSmaller(int index, int[] nums) {
        return index - 1 < 0 || nums[index - 1] < nums[index];
    }

    /**
     * Determines if the num[index + 1] value is less than the num[index] value.
     *
     * @param index Index value to examine
     * @param nums  Array of ints
     * @return true if num[index + 1] is less than num[index], false if not.
     */
    private static boolean isRightSmaller(int index, int[] nums) {
        return index + 1 >= nums.length || nums[index + 1] < nums[index];
    }

}
