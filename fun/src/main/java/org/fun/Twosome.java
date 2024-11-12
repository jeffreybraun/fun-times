package org.fun;

import java.util.HashMap;
import java.util.Map;

/**
 * Twosome - Two Sum
 * <p>
 * Just having fun adding together numbers in an array to match a target value.
 */
public class Twosome {

    /**
     * Given the array of nums, this method returns an array of the indexes of two numbers that
     * add up to the target value.
     *
     * @param nums   Array of integers
     * @param target target value for two values in the nums array to add up to.
     * @return integer array with the indexes of nums that contain the values that add up to the target value.
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        // Key:   Value to match against
        // Value: Corresponding value's index in the array
        Map<Integer, Integer> matchers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (matchers.containsKey(nums[i])) {
                result[0] = matchers.get(nums[i]);
                result[1] = i;
                break;
            } else {
                matchers.put(target - nums[i], i);
            }
        }
        return result;
    }

}
