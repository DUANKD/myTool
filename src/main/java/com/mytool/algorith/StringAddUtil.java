package com.mytool.algorith;

public class StringAddUtil {
    /**
     * 考虑有2个存储在string中的正整数（远大于int64）A和B，现请你实现一个函数，计算A+B的结果，如：
     * 11111111111111111111111
     * + 11111111111111111111110
     * = 22222222222222222222221
     * 函数定义如下：
     * string Multiply(string  num1, string num2) ;
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String Multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        char[] num1Arr = getReverseOrder(num1);
        char[] num2Arr = getReverseOrder(num2);
        int len = len1 > len2 ? len1 : len2;
        boolean carry = false;
        char[] result = new char[len + 1];
        for (int i = 0; i < len; i++) {
            int num1Temp = (int) num1Arr[i] - (int) '0';
            int num2Temp = (int) num2Arr[i] - (int) '0';
            int addTemp = num1Temp + num2Temp;
            if (carry) {
                addTemp++;
                carry = false;
            }
            if (addTemp >= 10) {
                carry = true;
                addTemp -= 10;
            }
            result[len - i] = (char) (addTemp + '0');
        }
        if (carry) {
            result[0] = (char) (1 + '0');
        }
        String resultStr = String.valueOf(result);
        return resultStr;
    }

    public static char[] getReverseOrder(String num) {
        char[] numStr = num.toCharArray();
        int len = num.length();
        char[] result = new char[len];
        for (int i = 0; i < numStr.length; i++) {
            result[len - 1 - i] = numStr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        String result = StringAddUtil.Multiply("1", "9");
        System.out.println(result);
    }
}
