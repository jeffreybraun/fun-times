package org.fun;

import static java.util.Objects.isNull;

/**
 * Determines the maximum depth of a binary tree.
 */
public class NochTieferNochTiefer {

    /**
     * Determines the maximum depth of a binary tree.
     *
     * @param root Binary Tree
     * @return the maximum depth value
     */
    public static int maxDepth(TreeNode root) {
        return depthCount(root);
    }

    /**
     * Determines the maximum depth of a binary tree.
     *
     * @param root Binary Tree
     * @return the maximum depth value
     */
    static int depthCount(TreeNode root) {
        if (isNull(root))
            return 0;

        int leftCount = depthCount(root.left);
        int rightCount = depthCount(root.right);
        return rightCount > leftCount
                ? rightCount + 1
                : leftCount + 1;
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
