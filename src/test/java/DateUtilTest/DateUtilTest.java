package DateUtilTest;


/**
 * @author: Administrator
 * @ClassName: DateUtilTest
 * @Description: TODO
 * @Create by: Administrator
 * @Date: 2020-08-2020/8/11 11:14:53
 */

import org.junit.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author duankd
 * @date 2020/8/11 11:14:53
 */
public class DateUtilTest {

    @Test
    public void dateOutTest() {
        Date date = new Date();
        System.out.println(date.getTime());
    }

    @Test
    public void getStaticDate() {
        long time1=System.currentTimeMillis();
        LocalDateTime dateTime = LocalDateTime.now();
        Date date = Date.from(Clock.systemDefaultZone().instant());
        System.out.println(dateTime.toString() + date.toString());
        System.out.println("end");
    }

    @Test
    public void getStaticDateTime() {
        long time1=System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            LocalDateTime dateTime = LocalDateTime.now();
        }
        long time2=System.currentTimeMillis();
        System.out.println(time2-time1);
        for (int i = 0; i < 100; i++) {
            Date date = Date.from(Clock.systemDefaultZone().instant());
        }
        long time3=System.currentTimeMillis();
        System.out.println(time3 -time2);
        System.out.println("end");
    }
}
