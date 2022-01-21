package baseTest;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author duankd
 * @ClassName DateTest
 * @date 2021-01-21 14:45:15
 */
public class DateTest {
    @Test
    void name() {
        Date firstCreateTime = new Date(1609430399000L);
        System.out.println(firstCreateTime);
        Date BEGIN_DATE = new Date(1577808000000L);
        System.out.println(firstCreateTime.after(BEGIN_DATE));
        Date date = new Date();
        System.out.println(firstCreateTime.after(date));
    }

    @Test
    void therrMonthAgo() {
        Date dNow = new Date();   //当前时间
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);//把当前时间赋给日历
        calendar.add(Calendar.MONTH, -3);  //设置为前3月
        dBefore = calendar.getTime();   //得到前3月的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置时间格式
        String defaultStartDate = sdf.format(dBefore);    //格式化前3月的时间
        String defaultEndDate = sdf.format(dNow); //格式化当前时间
        System.out.println("三个月之前时间=======" + defaultStartDate);
        System.out.println("当前时间===========" + defaultEndDate);
        long lSysTime1 = dBefore.getTime() / 1000;
        System.out.println("三个月之前时间=======" + lSysTime1);

    }
}
