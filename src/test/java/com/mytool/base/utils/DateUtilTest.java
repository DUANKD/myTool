package com.mytool.base.utils;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilTest {

    @Test
    void dateToLocalDateTimeString() {
        Date date=new Date();
        String dateStr=DateUtil.dateToLocalDateTimeString(date);
        System.out.println(dateStr);
        Date date1=null;
        String dateStr1=DateUtil.dateToLocalDateTimeString(date1);
    }
}