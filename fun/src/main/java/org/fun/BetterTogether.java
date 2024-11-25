package org.fun;

/**
 * Merge Two Sorted Arrays
 */
public class BetterTogether {

    /**
     * Merges two sorted arrays
     *
     * @param nums1 source data
     * @param nums2 source data
     * @return the result of merging the two source arrays
     */
    public static int[] mergeSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];

        int p1 = 0, p2 = 0, pR = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                result[pR++] = nums1[p1++];
            } else {
                result[pR++] = nums2[p2++];
            }
        }

        while (p1 < nums1.length) {
            result[pR++] = nums1[p1++];
        }

        while (p2 < nums2.length) {
            result[pR++] = nums2[p2++];
        }

        return result;
    }

}
