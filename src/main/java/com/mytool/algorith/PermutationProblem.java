package com.mytool.algorith;

import java.util.LinkedList;
import java.util.List;

/**
 * @author duankd
 * @description 全排列问题
 * @ClassName PermutationProblem
 * @date 2021-08-23 23:47:00
 */
public class PermutationProblem {
    private static List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输⼊⼀组不重复的数字，返回它们的全排列 */
    static List<List<Integer>> permute(int[] nums) { // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    static void backtrack(int[] nums, LinkedList<Integer> track) { // 触发结束条件

        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }
        /*if (track.size() == nums.length-1) {
            res.add(new LinkedList(track.add()));
            return;
        }*/
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择

            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进⼊下⼀层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);
    }
}
