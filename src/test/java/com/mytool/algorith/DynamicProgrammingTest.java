package com.mytool.algorith;

import org.junit.jupiter.api.Test;

class DynamicProgrammingTest {

    @Test
    void lengthOfLIS2() {
        int[] nums = new int[]{1, 4, 3, 4, 5};
        int result = DynamicProgramming.lengthOfLIS2(nums);
        System.out.println(result);
    }
}