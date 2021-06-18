package com.mytool.algorith;

public class LuckNum {

    /**
     *由1、14、144三个数拼接成的数字叫做幸运数，如1414，114，14414等都是幸运数。给出一个数，判断它是否是幸运数
     * @param number
     * @return
     */
    public static boolean lucky(int number) {
        boolean result = true;
        String a = String.valueOf(number);
        char[] b = a.toCharArray();
        int index = 1;
        for (int i = 0; i < b.length; i++) {
            char temp = b[i];
            switch (index) {
                case 1:
                    if (temp == '1') {
                        index++;
                    } else {
                        result = false;
                        return result;
                    }
                    break;
                case 2:
                    if (temp == '4') {
                        index++;
                    } else {
                        index = 1;
                        i--;
                    }
                    break;
                case 3:
                    if (temp == '4') {
                        index++;
                    } else {
                        index = 1;
                        i--;
                    }
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        boolean result =LuckNum.lucky(4);
        System.out.println(result);
    }

}
