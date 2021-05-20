package baseTest;

import org.junit.Test;

/**
 * @author duankd
 * @ClassName LongTest
 * @date 2021-04-30 17:58:44
 */
public class LongTest {
    @Test
    public void name() {
        long a=10000;
        double a1=(double) a;
        double b=a1/3;
        System.out.println(b);
    }

    /**
     * 二进制:0b
     * 八进制:0
     * 十六进制:0x
     */
    @Test
    public void name1() {
        int binary=0b101;
        int binary1=0B11;
        int octal=071;
        int hexadecimal=0x101;
        int hexadecimal1=0x11;
        Integer flag=binary;
        System.out.println((flag&0b100));
        System.out.println(binary1);
    }
}
