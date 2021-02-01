package baseTest;

import org.junit.jupiter.api.Test;

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
}
