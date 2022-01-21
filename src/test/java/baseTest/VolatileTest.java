package baseTest;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author duankd
 * @ClassName VolatileTest
 * @date 2021-01-12 16:19:27
 */
public class VolatileTest {

    int a, b, x, y;

    /**
     * 反射获取到unsafe
     * getField 只能获取public的，包括从父类继承来的字段。
     * getDeclaredField 可以获取本类所有的字段，包括private的，但是不能获取继承来的字段。
     * 注： 这里只能获取到private的字段，但并不能访问该private字段的值,除非加上setAccessible(true)
     */
    private Unsafe reflectGetUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (Unsafe) field.get(null);
    }

    @Test
    public void threadTest() {
        // 上述示例中手动插入内存屏障
        Thread t1 = new Thread(() -> {
            a = 1;
            // 插入LoadStore()屏障
            try {
                reflectGetUnsafe().storeFence();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            x = b;
        });
        Thread t2 = new Thread(() -> {
            b = 1;
            // 插入LoadStore()屏障
            try {
                reflectGetUnsafe().storeFence();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            y = a;
        });
    }

}
