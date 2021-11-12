package com.mytool.algorith;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeTest {

    @Test
    void longestPalindrome2() {
        String s="cbcbccde";
        String result=LongestPalindrome.longestPalindrome2(s);
        System.out.println(result);
    }
}