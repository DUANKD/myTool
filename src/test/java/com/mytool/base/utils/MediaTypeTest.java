package com.mytool.base.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediaTypeTest {

    @Test
    void isExist() {
        Integer a=5;
        boolean a1= MediaType.isExist(a);
        System.out.println(a1);
        Integer b=1;
        boolean b1= MediaType.isExist(b);
        System.out.println(a1);
        Long c=11L;
        boolean c1= MediaType.isExist(c);
        System.out.println(a1);
    }
}