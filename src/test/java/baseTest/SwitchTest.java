package baseTest;

import org.junit.Test;

/**
 * @author duankd
 * @ClassName SwitchTest
 * @date 2021-06-23 15:00:33
 */
public class SwitchTest {
    private final static String Abc = "4";

    @Test
    public void switchT() {
        String a = "4";
        switch (a) {
            case Abc:
                System.out.println("result "+Abc);
                break;
            case "1":
                System.out.println(1);
                break;
        }
    }
}
