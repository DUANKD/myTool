package com.mytool.algorith;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duankd
 * @ClassName JudgePoint24
 * @date 2022-01-21 10:47:14
 */
public class JudgePoint24 {
    private static Double TARGET = null;
    private static final double EPISLON = 1e-6;

    public static boolean judgePoint24(int target, int[] cards) {
        //if (cards == null || cards.length != 4) return false;
        if (cards == null) return false;
        TARGET = (double)target;
        double[] a = new double[cards.length];
        int i = 0;
        for (int num : cards) {
            a[i++] = (double) num;
        }
        return solve(a);
    }

    private static boolean solve(double[] a) {
        int n = a.length;
        if (n == 1) {
            return Math.abs(TARGET - a[0]) <= EPISLON;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double[] b = new double[n - 1];
                int index = 0;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        b[index++] = a[k];
                    }
                }
                for (double d : compute(a[i], a[j])) {
                    b[index] = d;
                    if (Math.abs(TARGET - d) <= EPISLON) {
                        return true;
                    }
                    if (solve(b)) return true;
                }
            }
        }
        return false;
    }

    private static List<Double> compute(double x, double y) {
        List<Double> ans = new ArrayList<>();
        ans.add(x + y);
        ans.add(x - y);
        ans.add(y - x);
        ans.add(x * y);
        if (y != 0) {
            ans.add(x / y);
        }
        if (x != 0) {
            ans.add(y / x);
        }
        return ans;
    }
}
