package baseTest;

import org.junit.Test;

import java.util.Date;
import java.util.Objects;

/**
 * @author duankd
 * @ClassName ObjectTest
 * @date 2021-09-03 13:26:33
 */
public class ObjectTest {
    @Test
    public void equals() {
        long mills = System.currentTimeMillis();
        Date date = new Date(mills);
        Date date1 = new Date(mills);
        Date date2 = null;
        Date date3 = null;
        if(Objects.equals(date2,date3)){
            System.out.println("1---Objects.equals(date2,date3)");
        }
        if(Objects.equals(date,date1)){
            System.out.println("2---Objects.equals(date,date1)");
        }
        if(Objects.equals(date,date2)){
            System.out.println("3---Objects.equals(date,date2)");
        }
    }
}
