package com.mytool.algorith;

import org.junit.jupiter.api.Test;

import java.util.List;

class SlidingWindowsTest {

    @Test
    void getMinWindows() {
        String str = "EBBANCF";
        String target = "ABC";
        String result = SlidingWindows.getMinWindows(str, target);
        System.out.println(result);
    }

    @Test
    void checkInclusion() {
        String str = "helloworld";
        String target = "owo";
        boolean result = SlidingWindows.checkInclusion(str, target);
        System.out.println(result);
    }

    @Test
    void findAnagrams() {
        String str = "cabebabacd";
        String target = "abc";
        List<Integer> result = SlidingWindows.findAnagrams(str, target);
        System.out.println(result);
    }

    @Test
    void lengthOfLongestSubstring() {
        String str = "aabab";
        int result = SlidingWindows.lengthOfLongestSubstring(str);
        System.out.println(result);
    }
}