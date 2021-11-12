package baseTest;

import com.mytool.model.TestModel;
import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author duankd
 * @ClassName ClassTest
 * @date 2021-11-11 16:40:07
 */
public class ClassTest {


    public static class BaseSeq<T> {
        private static AtomicLong atomicLong = new AtomicLong(10000);
        private Class<T> persistentClass;

        @SuppressWarnings("unchecked")
        public BaseSeq() {
            this.persistentClass =
                    (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            System.out.println(persistentClass);
            System.out.println(persistentClass.getSimpleName());
        }

        private synchronized Long getNextId(){
            return atomicLong.addAndGet(1);
        }
    }

    public class AttrSeq extends BaseSeq<TestModel> {

        public synchronized Long getNextId() {

            Long result = null;

            result = super.getNextId();

            return result;
        }

    }

    @Test
    void test1() {
        AttrSeq attrSeq=new AttrSeq();
        System.out.println(attrSeq.getNextId());
    }
}
