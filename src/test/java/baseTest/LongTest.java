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
        long a = 10000;
        double a1 = (double) a;
        double b = a1 / 3;
        System.out.println(b);
    }

    /**
     * 二进制:0b 八进制:0 十六进制:0x
     */
    @Test
    public void name1() {
        int binary = 0b101;
        int binary1 = 0B11;
        int octal = 071;
        int hexadecimal = 0x101;
        int hexadecimal1 = 0x11;
        Integer flag = binary;
        System.out.println((flag & 0b100));
        System.out.println(binary1);
    }

    @Test
    public void chengFa() {
        Long a = -1L;
        Long b = 1L;
        Long c = a * -1;
        if (b.equals(c)) {
            System.out.println("yes");
        } else {
            System.out.println("false");
        }
    }

    @Test
    public void chuFa() {
        Long a = 5000L;
        Long b = 0L;
        Long c = b / 60;
        long c1=(long)Math.ceil((double)b / 60);
        long d=a-c;
        System.out.println(d);
    }

    /**
     * X % 2^n = X & (2^n – 1)
     */
    @Test
    public void takeRemainder() {
        int a = 1050;
        int b = 1024;
        System.out.println("start");
        System.out.println("start  a%b=" + (a % b) + " a&(b-1)=" + (a & (b - 1)));
        for (int i = a; i < 1151; i++) {
            if (i % b == (i & (b - 1))) {
                System.out.println("i%b==(i&(b-1)) " + (i & (b - 1)) + " a=" + a + " b=" + b);
            }
        }
        System.out.println("end");
    }

    @Test
    public void printOut() {
        Long a=null;
        System.out.println("a="+String.valueOf(a));
    }
}
