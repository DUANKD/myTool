package com.mytool.algorith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duankd
 * @ClassName minWindows
 * @date 2021-09-13 23:05:15
 */
public class SlidingWindows {

    /**
     * 最小字符串方法
     *
     * @return
     */
    public static String getMinWindows(String str, String target) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (char c : target.toCharArray()) {
            need.put(c, (need.getOrDefault(c, 0) + 1));
        }
        int left = 0, right = 0;

        int valid = 0;
        //记录最小覆盖字串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < str.length()) {
            //c是待移入窗口的字符
            char c = str.charAt(right);
            //右移窗口
            right++;
            //进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            //判断左侧窗口是否需要收缩
            while (valid == need.size()) {
                //在这里更新最小覆盖字串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                //d是将移出窗口的字符
                char d = str.charAt(left);
                //左移窗口
                left++;
                //进行窗口内数据的更新
                if (need.containsKey(d)) {
                    if (windows.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }
        //返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : str.substring(start, start + len);
    }

    /**
     * 判断str中是否存在t的排列
     *
     * @param str
     * @param target
     * @return
     */
    public static boolean checkInclusion(String str, String target) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (char c : target.toCharArray()) {
            need.put(c, (need.getOrDefault(c, 0) + 1));
        }
        int left = 0, right = 0;

        int valid = 0;

        while (right < str.length()) {
            //c是待移入窗口的字符
            char c = str.charAt(right);
            //右移窗口
            right++;
            //进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            //判断左侧窗口是否需要收缩
            while (right - left >= target.length()) {
                //在这里判断是否找到了合法的字串
                if (valid == need.size()) {
                    return true;
                }
                //d是将移出窗口的字符
                char d = str.charAt(left);
                //左移窗口
                left++;
                //进行窗口内数据的更新
                if (need.containsKey(d)) {
                    if (windows.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }
        //未找到合法的字串
        return false;
    }


    /**
     * 找到字符串中所有字母异位词
     *
     * @param str
     * @param target
     * @return
     */
    public static List<Integer> findAnagrams(String str, String target) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (char c : target.toCharArray()) {
            need.put(c, (need.getOrDefault(c, 0) + 1));
        }
        int left = 0, right = 0;
        int valid = 0;

        //记录结果
        List<Integer> result = new ArrayList<>();
        while (right < str.length()) {
            //c是待移入窗口的字符
            char c = str.charAt(right);
            //右移窗口
            right++;
            //进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            //判断左侧窗口是否需要收缩
            while (right - left >= target.length()) {
                //在这里判断是否找到了合法的字串
                if (valid == need.size()) {
                    result.add(left);
                }
                //d是将移出窗口的字符
                char d = str.charAt(left);
                //左移窗口
                left++;
                //进行窗口内数据的更新
                if (need.containsKey(d)) {
                    if (windows.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }
        //未找到合法的字串
        return result;
    }

    /**
     * 无重复字符的最长子串
     *
     * @param str
     * @return
     */
    public static int lengthOfLongestSubstring(String str) {
        Map<Character, Integer> windows = new HashMap<>();
        int left = 0, right = 0;

        //记录结果
        int result = 0;
        while (right < str.length()) {
            //c是待移入窗口的字符
            char c = str.charAt(right);
            //右移窗口
            right++;
            //进行窗口内数据的一系列更新
            windows.put(c, windows.getOrDefault(c, 0) + 1);

            //判断左侧窗口是否需要收缩
            while (windows.getOrDefault(c, 0) > 1) {
                //d是将移出窗口的字符
                char d = str.charAt(left);
                //左移窗口
                left++;
                //进行窗口内数据的更新
                windows.put(d, windows.get(d) - 1);
            }
            result = Integer.max(result, right - left);
        }
        //未找到合法的字串
        return result;
    }

}
