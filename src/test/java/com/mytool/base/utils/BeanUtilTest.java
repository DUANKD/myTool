package com.mytool.base.utils;

import com.mytool.model.TestModel;
import com.mytool.model.TestModelTemp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

/**
 * @author duankd
 * @ClassName BeanUtilTest
 * @date 2021-01-21 12:16:15
 */
public class BeanUtilTest {
    @Test
    void copy() {
        TestModel testModel = new TestModel();
        testModel.setContext("123");
        testModel.setLongNumber(1234L);
        TestModelTemp testModelTemp = new TestModelTemp();
        BeanUtils.copyProperties(testModel, testModelTemp);
        System.out.println(testModelTemp);
    }

    @Test
    void name() {
        double a = 13897.83;
        double b = 1389783;
        double c = a / b;
        BigDecimal bigDecimal = new BigDecimal(c).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal bigDecimal1 = new BigDecimal("0.09").setScale(2, BigDecimal.ROUND_HALF_UP);
        if (bigDecimal.equals(bigDecimal1)) {
            System.out.println("equal");
        }
        if (bigDecimal.compareTo(bigDecimal1) == -1) {
            System.out.println("小于");
        }
        if (bigDecimal.compareTo(bigDecimal1) == 0) {
            System.out.println("等于");
        }
        if (bigDecimal.compareTo(bigDecimal1) == 1) {
            System.out.println("大于");
        }

        //BeanUtil.copyProperties(springFestivalRecord, recordVO);
    }

    @Test
    void name1() {
        double a = 1389782;
        double b = 1389783;
        double c = a / b;
        BigDecimal bigDecimal = new BigDecimal(c).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal bigDecimal1 = getBigDecimal(bigDecimal);
        System.out.println(bigDecimal1);
    }

    private static BigDecimal minBigDecimal = new BigDecimal("0.01").setScale(2, BigDecimal.ROUND_HALF_UP);
    private static BigDecimal halfBigDecimal = new BigDecimal("0.5").setScale(2, BigDecimal.ROUND_HALF_UP);
    private static BigDecimal maxBigDecimal = new BigDecimal("0.99").setScale(2, BigDecimal.ROUND_HALF_UP);

    static BigDecimal getBigDecimal(BigDecimal bigDecimal) {
        if (bigDecimal.compareTo(minBigDecimal) == -1) {
            return minBigDecimal;
        } else if (bigDecimal.compareTo(maxBigDecimal) == 1) {
            return maxBigDecimal;
        } else {
            return bigDecimal;
        }
    }

    @Test
    void getBeanClass() {
        Long aa = Long.valueOf(1);
        BeanUtil.getBeanClass(aa);
    }
}
