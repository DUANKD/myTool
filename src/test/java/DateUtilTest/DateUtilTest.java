package DateUtilTest;


/**
 * @author: Administrator
 * @ClassName: DateUtilTest
 * @Description: TODO
 * @Create by: Administrator
 * @Date: 2020-08-2020/8/11 11:14:53
 */

import com.mytool.base.utils.DateUtil;
import org.junit.Test;

import java.text.ParseException;
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
        long time1 = System.currentTimeMillis();
        LocalDateTime dateTime = LocalDateTime.now();
        Date date = Date.from(Clock.systemDefaultZone().instant());
        System.out.println(dateTime.toString() + date.toString());
        System.out.println("end");
    }

    @Test
    public void getStaticDateTime() {
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            LocalDateTime dateTime = LocalDateTime.now();
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        for (int i = 0; i < 100; i++) {
            Date date = Date.from(Clock.systemDefaultZone().instant());
        }
        long time3 = System.currentTimeMillis();
        System.out.println(time3 - time2);
        System.out.println("end");
    }

    @Test
    public void isLegalDate() {
        String date = "2021-1-28 12:5:5";
        String format = "yyyy-MM-dd HH:mm:ss";
        boolean result = DateUtil.isLegalDate(date, format);
        System.out.println(result);
    }

    @Test
    public void toDateFirstSeconds() {
        Date date = new Date();
        Date newDate = DateUtil.toDateFirstSeconds(date);
        System.out.println(newDate);
    }
    //安全
    private static class SimpleDateFormatThread extends Thread {

        private String dateStr;

        public SimpleDateFormatThread(String dateStr){
            this.dateStr = dateStr;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.getName()+":"+DateUtil.parse(dateStr));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    //不安全
    private static class SimpleDateFormatThreadNoSafe extends Thread {

        private String dateStr;

        public SimpleDateFormatThreadNoSafe(String dateStr){
            this.dateStr = dateStr;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.getName()+":noSafe:"+DateUtil.parseNoSafe(dateStr));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void SimpleDateFormatThreadTest() {
        String dateStr = "2018-11-03 10:02:47";
        System.out.println("data: "+ dateStr);
        for(int i = 0; i < 10; i++){
            new SimpleDateFormatThread(dateStr).start();
        }
        for(int i = 0; i < 10; i++){
            new SimpleDateFormatThreadNoSafe(dateStr).start();
        }
        //wait()方法会释放 CPU 执行权 和 占有的锁。
        //this.wait((long)10*1000);
        this.notify();
        //sleep(long)方法仅释放 CPU 使用权，锁仍然占用；线程被放入超时等待队列，
        // 与yield 相比，它会使线程较长时间得不到运行。
        try {
            Thread.sleep((long)10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
