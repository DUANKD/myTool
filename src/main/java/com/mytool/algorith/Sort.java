package com.mytool.algorith;

/**
 * @author duankd
 * @ClassName Sort
 * @date 2021-11-19 15:28:24
 */
public class Sort {

    /*
     * 快速排序
     *
     * 参数说明：
     *     array -- 待排序的数组
     *     left -- 数组的左边界(例如，从起始位置开始排序，则l=0)
     *     right -- 数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
     */
    public static int[] quickSortDouble(int[] array, int left, int right) {

        if (left < right) {
            int i = division(array, left, right);
            quickSortDouble(array, left, i - 1); /* 递归调用 */
            quickSortDouble(array, i + 1, right); /* 递归调用 */
        }
        return array;
    }

    private static int division(int[] array, int left, int right) {
        // 以最左边的数(left)为基准
        int base = array[left];
        while (left < right) {
            // 从序列右端开始，向左遍历，直到找到小于base的数
            while (left < right && array[right] >= base)
                right--;
            // 找到了比base小的元素，将这个元素放到最左边的位置
            array[left] = array[right];

            // 从序列左端开始，向右遍历，直到找到大于base的数
            while (left < right && array[left] <= base)
                left++;
            // 找到了比base大的元素，将这个元素放到最右边的位置
            array[right] = array[left];
        }

        // 最后将base放到left位置。此时，left位置的左侧数值应该都比left小；
        // 而left位置的右侧数值应该都比left大。
        array[left] = base;
        return left;
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        //基准点
        int partitionIndex;
        if (left < right) {
            partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    // 分区操作
    private static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[left]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, left, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private static void heapify(int[] arr, int len, int i) {    // 堆调整
        int left = 2 * i + 1,
                right = 2 * i + 2,
                largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, len - 1, largest);
        }
    }

    public static int[] heapSort(int[] arr) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr, len, i);
        }
        for (int i = len - 1; i >= 0; i--) {
            swap(arr, 0, i);

            heapify(arr, i, 0);
        }
        return arr;
    }
}
