package org.fun;

/**
 * Finds a peak element is an element in an array.
 * A peak element is an element that is greater than its neighbors.
 */
public class FindersPeakers {

    /**
     * Finds a peak element is an element in an array, and returns it's index value.
     * A peak element is an element that is greater than its neighbors.
     *
     * @param nums source data
     * @return Index position of peek element.
     */
    public static int findPeakElementInNTime(int[] nums) {
        int result = 0;
        int peak = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (peak > nums[i]) {
                break;
            } else {
                peak = nums[i];
                result = i;
            }
        }
        return result;
    }

}
