package org.fun;

/**
 * This class removes duplicates from a supplied sorted array.
 */
public class AttackTheClones {

    /**
     * Removes duplicates from a sorted array, and the returned value indicates how many of unique values exist.
     *
     * @param nums source data
     * @return the total number of unique elements
     */
    public static int removeDuplicates(int[] nums) {
        int openSpot = 0;
        int examineLocation = 0;
        while (examineLocation < nums.length) {
            if (examineLocation == nums.length - 1 || nums[examineLocation] != nums[examineLocation + 1]) {
                nums[openSpot] = nums[examineLocation];
                openSpot++;
            }
            examineLocation++;
        }
        return openSpot;
    }

}
