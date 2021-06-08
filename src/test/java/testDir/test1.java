package testDir;

/**
 * @author duankd
 * @ClassName test1
 * @date 2021-04-28 0:00:57
 */
public class test1 {
    public static void main(String[] ares){
        staticFunction( );
    }
    static test1 st = new test1();
    static
    {
        System.out.println("1");
    }
    {
        System.out.println("2");
    }
    static{
        System.out.println("2.1");
    }
    test1() {
        System.out.println("3");
        System.out.println(" a=" + a + " ,b=" + b);
    }
    public static void staticFunction(){
        System.out.println("4");
    }
    int a=110;
    static int b=112;
}
