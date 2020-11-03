package DateUtilTest;


/**
 * @author: Administrator
 * @ClassName: DateUtilTest
 * @Description: TODO
 * @Create by: Administrator
 * @Date: 2020-08-2020/8/11 11:14:53
 */

import org.junit.Test;

import java.util.Date;

/**
 * @author duankd
 * @date 2020/8/11 11:14:53
 */
public class DateUtilTest {

    @Test
    public void dateOutTest() {
        Date date= new Date();
        System.out.println(date.getTime());
    }
}
