package org.fun;

import static java.util.Objects.isNull;

/**
 * This class provides functionality for calculating root-to-leaf sums and determines
 * if this matches a requested target value.
 */
public class LeafTheSumsToMe {

    /**
     * Determines if the supplied tree (root) has a root-to-leaf path such that adding up all
     * the values along the path equals targetSum.
     * A leaf is a node with no children.
     *
     * @param root      The root tree node
     * @param targetSum The value desired for root-to-leaf summation.
     * @return true if the targetSum is equal to a root-to-leaf summation; false if not.
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return checkTarget(root, targetSum);
    }

    /**
     * Determines if the supplied tree (root) has a root-to-leaf path such that adding up all
     * the values along the path equals targetSum.
     * A leaf is a node with no children.
     *
     * @param root      The root tree node
     * @param targetSum The value desired for root-to-leaf summation.
     * @return true if the targetSum is equal to a root-to-leaf summation; false if not.
     */
    static boolean checkTarget(TreeNode root, int targetSum) {
        if (isNull(root))
            return false;

        int countDown = targetSum - root.val;
        return (isNull(root.left) && isNull(root.right) && countDown == 0)
                || (checkTarget(root.left, countDown) || checkTarget(root.right, countDown));
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
