package org.fun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * This class contains routines to find a number missing from an array of 0-n integers.
 * Having fun trying different solutions for this problem.
 */
public class IWouldntSayImMissingTheNumberBob {

    /**
     * Identifies the single missing number in the supplied array of nums containing n distinct numbers
     * in the range [0, n]
     * Clarification note: Since this is 0 to n, numbers found from 0 to n-1 indicates the missing number is n.
     *
     * @param nums Array containing n distinct numbers in the range [0, n]
     * @return The single missing number from the supplied array of 0 to n.
     */
    public static int missingNumberGaussSum(int[] nums) {
        int expectedSum = (nums.length * (nums.length + 1)) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    /**
     * Identifies the single missing number in the supplied array of nums containing n distinct numbers
     * in the range [0, n]
     * Clarification note: Since this is 0 to n, numbers found from 0 to n-1 indicates the missing number is n.
     *
     * @param nums Array containing n distinct numbers in the range [0, n]
     * @return The single missing number from the supplied array of 0 to n.
     */
    public static int missingNumberBinarySearch(int[] nums) {
        Arrays.sort(nums);

        //If all numbers are accounted for, then the missing number is the next number to come in the sequence.
        int result = nums.length;

        if (nums[nums.length - 1] != nums.length - 1) {
            int left = 0;
            int right = nums.length - 1;
            boolean foundOne = false;
            while (left < right) {
                int mid = ((right - left) / 2) + left;
                if (mid == nums[mid]) {
                    left = mid;
                    if (foundOne) {
                        break;
                    }
                } else if (mid < nums[mid]) {
                    right = mid;
                    result = mid;
                    foundOne = true;
                }
            }
        }
        return result;
    }

    /**
     * Identifies the single missing number in the supplied array of nums containing n distinct numbers
     * in the range [0, n]
     * Clarification note: Since this is 0 to n, numbers found from 0 to n-1 indicates the missing number is n.
     *
     * @param nums Array containing n distinct numbers in the range [0, n]
     * @return The single missing number from the supplied array of 0 to n.
     */
    public static int missingNumberParallel(int[] nums) {
        List<Integer> possibleValues = Collections.synchronizedList(new ArrayList<>(nums.length + 1));
        IntStream.range(0, nums.length + 1)
                .parallel()
                .forEach(possibleValues::add);

        for (int i : nums) {
            possibleValues.remove((Integer) i);
        }

        return possibleValues.get(0);
    }

}
