package com.mytool.algorith;

/**
 * 最长回文字符串
 * @author duankd
 * @ClassName LongestPalindrome
 * @date 2021-11-12 14:59:10
 */
public class LongestPalindrome {


    /**
     * 插入前缀^#和后缀#$和中间的#
     * @param s
     * @return
     */
    private static String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        StringBuilder ret = new StringBuilder("^");
        for (int i = 0; i < n; i++){
            ret.append("#").append(s.charAt(i));
        }
        ret.append("#$");
        return ret.toString();
    }

    // 马拉车算法 时间复杂度 0（n），空间复杂度：O（n）
    public static String longestPalindrome2(String s) {
        String temp = preProcess(s);
        int n = temp.length();
        //从中心扩展的最大个数
        int[] P = new int[n];
        int center = 0, right = 0;
        for (int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * center - i;
            if (right > i) {
                P[i] = Math.min(right - i, P[i_mirror]);// 防止超出 R
            } else {
                P[i] = 0;// 等于 R 的情况
            }

            // 碰到之前讲的三种情况时候，需要利用中心扩展法
            while (temp.charAt(i + 1 + P[i]) == temp.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // 判断是否需要更新 R
            if (i + P[i] > right) {
                center = i;
                right = i + P[i];
            }
        }

        // 找出 P 的最大值
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2; //最开始讲的求原字符串下标
        return s.substring(start, start + maxLen);
    }
}
