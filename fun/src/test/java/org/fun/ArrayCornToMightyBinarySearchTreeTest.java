package org.fun;

import org.junit.jupiter.api.Test;

class ArrayCornToMightyBinarySearchTreeTest {

    @Test
    void test(){
        int[] nums = new int[]{-10,-3,0,5,9};
        ArrayCornToMightyBinarySearchTree.TreeNode result = ArrayCornToMightyBinarySearchTree.sortedArrayToBST(nums);
    }

    @Test
    void test2(){
        int[] nums = new int[]{1,3};
        ArrayCornToMightyBinarySearchTree.TreeNode result = ArrayCornToMightyBinarySearchTree.sortedArrayToBST(nums);
    }

}
