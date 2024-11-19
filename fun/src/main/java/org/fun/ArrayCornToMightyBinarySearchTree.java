package org.fun;

import java.util.Arrays;

/**
 * Converts Sorted Array to Binary Search Tree
 */
public class ArrayCornToMightyBinarySearchTree {

    /**
     * Converts Sorted Array to Binary Search Tree of TreeNodes
     *
     * @param nums sorted array of integers
     * @return TreeNode with values from the supplied sorted array
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        return createNode(nums);
    }

    /**
     * Converts Sorted Array (nums) to Binary Search Tree of TreeNodes
     *
     * @param nums sorted array of integers
     * @return TreeNode with values from the supplied sorted array
     */
    static TreeNode createNode(int[] nums) {
        return switch (nums.length) {
            case 1 -> new TreeNode(nums[0]);
            case 2 -> new TreeNode(nums[1], new TreeNode(nums[0]), null);
            default -> {
                int mid = nums.length / 2;
                yield new TreeNode(
                        nums[mid],
                        createNode(Arrays.copyOfRange(nums, 0, mid)),
                        createNode(Arrays.copyOfRange(nums, mid + 1, nums.length)));
            }
        };
    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
