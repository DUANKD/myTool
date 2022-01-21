package com.mytool.algorith;

import java.util.Arrays;

/**
 * 动态规划
 *
 * @author duankd
 * @ClassName DynamicProgramming
 * @date 2021-09-15 23:17:38
 */
public class DynamicProgramming {

    /**
     * 最长递增子序列 The Longest Increasing Subsequence (LIS)
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        //base case :dp 数组全部初始化为1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        //要重新遍历一遍数组，找到最长的递增子序列长度
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static int lengthOfLIS2(int[] nums) {
        int[] top = new int[nums.length];
        //牌堆数初始化为0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            //要处理的扑克牌
            int poker = nums[i];
            /* ** 搜索左侧边界的二分搜索 ** */
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            /***************************************/

            //没找到合适的牌堆，新建一堆
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }
        //牌堆数就是 LIS 长度
        return piles;
    }
}
