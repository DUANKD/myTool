package baseTest;

import com.mytool.base.utils.MediaType;
import org.junit.jupiter.api.Test;

/**
 * @author duankd
 * @ClassName MethodTest
 * @date 2021-03-23 17:08:28
 */
public class MethodTest {

    @Test
    void equalsTest() {
        Long a=2L;
        if (a.equals((long)MediaType.Video.getValue()) || a.equals((long)MediaType.Music.getValue())){
            System.out.println("aaaaaa");
        }
        System.out.println("end");
    }
}
