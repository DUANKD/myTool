package com.mytool.algorith;

/**
 *
 */
public class FileCopy {
    /**
     * 某一个大文件被拆成了N个小文件，每个小文件编号从0至N-1，相应大小分别记为S(i)。 给定磁盘空间为C，试实现一个函数从N个文件中连续选出若干个文件拷贝到磁盘中，使得磁盘剩余空间最小。
     */
    static Result MaximumCopy(int[] fileArr, int space) {
        Result result = new Result();
        int len = fileArr.length;
        int[] dp = new int[len];
        int[] startArr = new int[len];
        int[] endArr = new int[len];
        dp[0] = fileArr[0];
        startArr[0] = 0;
        for (int i = 1; i < len; i++) {
            int temp = fileArr[i] + dp[i - 1];
            int startIndex = startArr[i - 1];
            if (temp > space) {
               /* if (temp - fileArr[startIndex] <= space) {
                    dp[i] = fileArr[i] + dp[i - 1] - fileArr[startIndex];
                    startArr[i] = startArr[i - 1] + 1;
                    endArr[i] = i;
                } else {
                    dp[i] = dp[i - 1];
                    startArr[i] = startArr[i - 1];
                    endArr[i] = i - 1;
                }*/
                for (int j = startIndex; j < i + 1; j++) {
                    int temp2 = temp - fileArr[j];

                    if (temp2 > space) {
                        temp = temp2;
                    } else {
                        dp[i] = temp2;
                        startArr[i] = j;
                    }
                }
            } else {
                dp[i] = fileArr[i] + dp[i - 1];
                startArr[i] = startArr[i - 1];
                endArr[i] = i;
            }
        }

        int maxSum = dp[0];
        int start = 0;
        int end = 0;
        for (int i = 1; i < len; i++) {
            if (dp[i] > maxSum && dp[i] <= space) {
                maxSum = dp[i];
                start = startArr[i];
                end = endArr[i];
            }
        }
        result.setStart(start);
        result.setEnd(end);
        result.setMaxSum(maxSum);
        return result;
    }

    static Result maximumCopy(int[] fileArr, int space) {
        Result result = new Result();
        int len = fileArr.length;
        int[] dp = new int[len];
        int[] startArr = new int[len];
        dp[0] = fileArr[0];
        startArr[0] = 0;
        int calculationAmount = 0;
        for (int i = 1; i < len; i++) {
            calculationAmount++;
            if (fileArr[i] > space) {
                startArr[i] = -1;
                continue;
            }
            int startIndex = startArr[i - 1];
            int temp = fileArr[i];
            startArr[i] = i;
            if (startIndex == -1) {

            } else {
                temp = fileArr[i] + dp[i - 1];
                if (temp > space) {
                    for (int j = startIndex; j < i + 1; j++) {
                        calculationAmount++;
                        int temp2 = temp - fileArr[j];

                        if (temp2 > space) {
                            temp = temp2;
                        } else {
                            dp[i] = temp2;
                            startArr[i] = j + 1;
                            break;
                        }
                    }
                } else {
                    dp[i] = fileArr[i] + dp[i - 1];
                    startArr[i] = startArr[i - 1];
                }
            }

        }

        int maxSum = dp[0];
        int start = 0;
        int end = 0;
        for (int i = 1; i < len; i++) {
            if (dp[i] > maxSum && dp[i] <= space) {
                maxSum = dp[i];
                start = startArr[i];
                end = i;
            }
        }
        result.setStart(start);
        result.setEnd(end);
        result.setMaxSum(maxSum);
        return result;
    }

    static class Result {
        int start;
        int end;
        int maxSum;

        public Result() {
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getMaxSum() {
            return maxSum;
        }

        public void setMaxSum(int maxSum) {
            this.maxSum = maxSum;
        }
    }

    public static void main(String[] args) {
        int[] fileArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int space = 10;
        Result result = FileCopy.maximumCopy(fileArr, space);
        System.out.println(result);
    }
}
