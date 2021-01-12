package baseTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duankd
 * @ClassName MapTest
 * @date 2020-12-11 9:34:43
 */
public class MapTest {

    @Test
    public void ashMapTest(){
        Map<String,String>  map=new HashMap<>();
        int cap =1;
        int n = cap - 1;
        n |= n >>> 1;
    }
}
