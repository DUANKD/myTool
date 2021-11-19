package com.mytool.algorith;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SortTest {

    @Test
    void quickSort() {
        int[] arrays = {12, 1, 5, 9, 13, 8, 3, 7, 15, 2};
        int[] result = Sort.quickSort(arrays, 0, arrays.length - 1);
        int[] result1 = Sort.quickSortDouble(arrays, 0, arrays.length - 1);
        System.out.println("result:" + Arrays.toString(result));
        System.out.println("result1:" + Arrays.toString(result1));
    }
}