package com.mytool.algorith;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void maxSubArray() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = Solution.maxSubArray(nums);
        System.out.println(result);
    }
}