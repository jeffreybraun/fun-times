package org.fun;

import org.junit.jupiter.api.Test;

class ZeroedOutTest {

    @Test
    void test(){

        int[][] matrix = new int[][]{{0,0,0,5},{4,3,1,4},{0,1,1,4}, {1,2,1,3}, {0,0,1,1}};
        ZeroedOut.setZeroes(matrix);

        System.out.println("done?");

    }

    @Test
    void test2(){

        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        ZeroedOut.setZeroes(matrix);

        System.out.println("done?");

    }


}
