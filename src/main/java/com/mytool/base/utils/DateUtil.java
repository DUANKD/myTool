package com.mytool.base.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @author duankd
 * @ClassName BeanUtil
 * @date 2021-02-05 10:45:52
 */
public class DateUtil {

    private static final Logger log = LoggerFactory.getLogger(DateUtil.class);


    public static final String full_pattern = "yyyy-MM-dd HH:mm:ss";
    public static final String date_pattern = "yyyy-MM-dd";

    public static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendValue(ChronoField.YEAR)
            .appendLiteral("-")
            .appendValue(ChronoField.MONTH_OF_YEAR)
            .appendLiteral("-")
            .appendValue(ChronoField.DAY_OF_MONTH)
            .appendLiteral(" ")
            .appendValue(ChronoField.HOUR_OF_DAY)
            .appendLiteral(":")
            .appendValue(ChronoField.MINUTE_OF_HOUR)
            .appendLiteral(":")
            .appendValue(ChronoField.SECOND_OF_MINUTE)
            .toFormatter();

    public static final DateTimeFormatter DATE_FORMATTER = new DateTimeFormatterBuilder()
            .appendValue(ChronoField.YEAR)
            .appendLiteral("-")
            .appendValue(ChronoField.MONTH_OF_YEAR)
            .appendLiteral("-")
            .appendValue(ChronoField.DAY_OF_MONTH)
            .toFormatter();


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

    /**
     * 获取三个月前的日期
     *
     * @return
     */
    public static Date getThreeMonthsAgo() {
        //当前时间
        Date dNow = new Date();
        Date dBefore = new Date();
        //得到日历
        Calendar calendar = Calendar.getInstance();
        //把当前时间赋给日历
        calendar.setTime(dNow);
        //设置为前3月
        calendar.add(Calendar.MONTH, -3);
        //得到前3月的时间
        dBefore = calendar.getTime();
        return dBefore;
    }


    /**
     * 时间之差
     *
     * @return
     */
    public static Duration getDuration(LocalDateTime begin, LocalDateTime end) {
        return Duration.between(begin, end);
    }

    /**
     * @param begin
     * @param end
     * @return
     */
    public static Period getPeriod(LocalDate begin, LocalDate end) {
        return Period.between(begin, end);
    }

    /**
     * 时间之差
     *
     * @param begin
     * @param end
     * @return
     */
    public static long getChronoUnitDays(LocalDateTime begin, LocalDateTime end) {
        return ChronoUnit.DAYS.between(begin, end);
    }

    /**
     * LocalDate转Date
     *
     * @param localDate
     * @return
     */
    public static Date localDate2Date(LocalDate localDate) {
        if (null == localDate) {
            return null;
        }
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * Date转LocalDate
     *
     * @param date
     */
    public static LocalDate date2LocalDate(Date date) {
        if (null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 时间字符串转为对应的时间戳
     *
     * @param dateStr
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(String dateStr) {
        return LocalDateTime.parse(dateStr, DATE_TIME_FORMATTER);
    }

    /**
     * 时间字符串转为对应的时间戳
     *
     * @param dateStr
     * @return
     */
    public static long dateToStamp(String dateStr) {
        long result = dateToLocalDateTime(dateStr).toInstant(ZoneOffset.ofHours(12)).toEpochMilli();
        return result;
    }

    /**
     * 时间戳转为对应的date
     *
     * @param timestamp
     * @return
     */
    public static Date timestampToDate(long timestamp) {
        LocalDateTime localDateTime = ofEpochMilli(timestamp);
        return toDate(localDateTime);
    }


    /**
     * 时间戳转为对应的时间字符串
     *
     * @param timestamp
     * @return
     */
    public static String timestampToString(long timestamp) {
        return localDateTimeToLocalString(ofEpochMilli(timestamp));
    }

    /**
     * java.util.Date --> String
     *
     * @param date
     * @return
     */
    public static String dateToLocalDateTimeString(Date date) {
        LocalDateTime localDateTime = ofDate(date);
        return localDateTime.format(DATE_TIME_FORMATTER);
    }

    /**
     * java.util.Date --> String
     *
     * @param date
     * @return
     */
    public static String dateToLocalDateString(Date date) {
        LocalDateTime localDateTime = ofDate(date);
        return localDateTime.format(DATE_FORMATTER);
    }

    /**
     * java.util.LocalDateTime --> String
     *
     * @param localDateTime
     * @return
     */
    public static String localDateTimeToLocalString(LocalDateTime localDateTime) {
        return localDateTime.format(DATE_TIME_FORMATTER);
    }

    /**
     * 获取到毫秒级时间戳
     *
     * @param localDateTime 具体时间
     * @return long 毫秒级时间戳
     */
    public static long toEpochMilli(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * 毫秒级时间戳转 LocalDateTime
     *
     * @param epochMilli 毫秒级时间戳
     * @return LocalDateTime
     */
    public static LocalDateTime ofEpochMilli(long epochMilli) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneOffset.of("+8"));
    }

    /**
     * 获取到秒级时间戳
     *
     * @param localDateTime 具体时间
     * @return long 秒级时间戳
     */
    public static long toEpochSecond(LocalDateTime localDateTime) {
        return localDateTime.toEpochSecond(ZoneOffset.of("+8"));
    }

    /**
     * 秒级时间戳转 LocalDateTime
     *
     * @param epochSecond 秒级时间戳
     * @return LocalDateTime
     */
    public static LocalDateTime ofEpochSecond(long epochSecond) {
        return LocalDateTime.ofEpochSecond(epochSecond, 0, ZoneOffset.of("+8"));
    }

    /**
     * Date时间类转LocalDateTime
     *
     * @param date Date时间类
     * @return LocalDateTime
     */
    public static LocalDateTime ofDate(Date date) {
        return date.toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
    }

    /**
     * LocalDateTime时间类转 Date时间类
     *
     * @param localDateTime LocalDateTime时间类
     * @return Date时间类
     */
    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneOffset.of("+8")).toInstant());
    }

    /**
     * 获取那天的最后一秒
     *
     * @param date
     * @return Date时间类
     */
    public static Date toDateLastSeconds(Date date) {
        //转为LocalDate
        LocalDate localDate = date2LocalDate(date);
        //转为date 获得当天开始
        Date newDate = localDate2Date(localDate);
        //一天的毫秒
        int dayMis = 1000 * 60 * 60 * 24;
        //增加一天的毫秒-1
        date.setTime(newDate.getTime() + dayMis - 1000);
        return date;
    }

    /**
     * 获取那天的最后一秒
     *
     * @param date
     * @return Date时间类
     */
    public static Date toDateFirstSeconds(Date date) {
        //转为LocalDate
        LocalDate localDate = date2LocalDate(date);
        //转为date 获得当天开始
        Date newDate = localDate2Date(localDate);
        return newDate;
    }

    /**
     * 获取那天的最后一毫秒
     *
     * @param date
     * @return Date时间类
     */
    public static Date toDateLastMilliseconds(Date date) {
        //转为LocalDate
        LocalDate localDate = date2LocalDate(date);
        //转为date 获得当天开始
        Date newDate = localDate2Date(localDate);
        //一天的毫秒
        int dayMis = 1000 * 60 * 60 * 24;
        //增加一天的毫秒-1
        date.setTime(newDate.getTime() + dayMis - 1);
        return date;
    }

    /**
     *  使用ThreadLocal, 也是将共享变量变为独享，线程独享肯定能比方法独享在并发环境中能减少不少创建对象的开销。
     *  如果对性能要求比较高的情况下，一般推荐使用这种方法。
     */
    private static ThreadLocal<DateFormat> sdfThreadLocal =  new ThreadLocal<DateFormat>(){
        @Override
        public SimpleDateFormat initialValue(){
            return  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static  String formatDate(Date date)throws ParseException {
        return sdfThreadLocal.get().format(date);
    }

    public static Date parse(String strDate) throws ParseException {

        return sdfThreadLocal.get().parse(strDate);
    }

    private static final SimpleDateFormat sdfNoSafe = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static  String formatDateNoSafe(Date date)throws ParseException {
        return sdfNoSafe.format(date);
    }

    public static Date parseNoSafe(String strDate) throws ParseException{

        return sdfNoSafe.parse(strDate);
    }

    /*
      Date转换为时间戳
     */
    public static Long  toUnixTime(Date date) {
        long unix;
        try {
            unix = date.getTime() / 1000;
        } catch (Exception e) {
            log.error("date={},e={}", date, e);
            return -1L;
        }
        return unix;
    }
}
