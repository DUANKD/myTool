package com.mytool.algorith;

import org.junit.jupiter.api.Test;

class JudgePoint24Test {

    @Test
    void judgePoint24() {
        int[] card = new int[]{10, 24, 22, 26};
        int target = 25;
        boolean result = JudgePoint24.judgePoint24(target, card);
        System.out.println(result);
    }
}