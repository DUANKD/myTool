package com.mytool.base.utils;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author duankd
 * @ClassName BeanUtil
 * @date 2021-02-05 10:45:52
 */
public class DateUtil {


    /**
     * 判断时间格式 格式必须为“YYYY-MM-dd” 2004-2-30 是无效的 2003-2-29 是无效的
     *
     * @param sDate
     * @return
     */
    public static boolean isLegalDate(String sDate, String format) {
        if (StringUtils.isEmpty(sDate) || StringUtils.isEmpty(format) || sDate.length() > format.length()) {
            return false;
        }
        DateFormat formatter = new SimpleDateFormat(format);
        try {
            Date date = formatter.parse(sDate);
            //return sDate.equals(formatter.format(date));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
