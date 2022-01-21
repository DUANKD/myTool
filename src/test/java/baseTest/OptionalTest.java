package baseTest;

import com.mytool.model.TestModel;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author duankd
 * @ClassName OptionalTest
 * @date 2021-08-05 12:18:03
 */
public class OptionalTest {

    /**
     * 1. 创建：
     * <p>
     * Optional.empty()： 创建一个空的 Optional 实例
     * <p>
     * Optional.of(T t)：创建一个 Optional 实例，当 t为null时抛出异常
     * <p>
     * Optional.ofNullable(T t)：创建一个 Optional 实例，但当 t为null时不会抛出异常，而是返回一个空的实例
     * <p>
     * 2. 获取：
     * <p>
     * get()：获取optional实例中的对象，当optional 容器为空时报错
     * <p>
     * 3. 判断：
     * <p>
     * isPresent()：判断optional是否为空，如果空则返回false，否则返回true
     * <p>
     * ifPresent(Consumer c)：如果optional不为空，则将optional中的对象传给Comsumer函数
     * <p>
     * orElse(T other)：如果optional不为空，则返回optional中的对象；如果为null，则返回 other 这个默认值
     * <p>
     * orElseGet(Supplier<T> other)：如果optional不为空，则返回optional中的对象；如果为null，则使用Supplier函数生成默认值other
     * <p>
     * orElseThrow(Supplier<X> exception)：如果optional不为空，则返回optional中的对象；如果为null，则抛出Supplier函数生成的异常
     * <p>
     * 4. 过滤：
     * <p>
     * filter(Predicate<T> p)：如果optional不为空，则执行断言函数p，如果p的结果为true，则返回原本的optional，否则返回空的optional
     * <p>
     * 5. 映射：
     * <p>
     * map(Function<T, U> mapper)：如果optional不为空，则将optional中的对象 t 映射成另外一个对象 u，并将 u 存放到一个新的optional容器中。
     * <p>
     * flatMap(Function< T,Optional<U>> mapper)：跟上面一样，在optional不为空的情况下，将对象t映射成另外一个optional
     * <p>
     * 区别：map会自动将u放到optional中，而flatMap则需要手动给u创建一个optional
     */

    /**
     * 创建一个空的 Optional 实例
     */
    @Test
    public void whenCreateEmptyOptional_thenNull() {
        Optional<TestModel> emptyOpt = Optional.empty();
        TestModel testModel = emptyOpt.get();
        System.out.println(testModel);
    }

    @Test
    public void whenCreateOfEmptyOptional_thenNullPointerException() {
        try {
            Optional<TestModel> emptyOpt = Optional.empty();
            TestModel testModel = emptyOpt.get();
            Optional<TestModel> opt = Optional.of(testModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 访问 Optional 对象的值
     * <p>
     * 从 Optional 实例中取回实际值对象的方法之一是使用 get() 方法：
     */
    @Test
    public void whenCreateOfNullableOptional_thenOk() {
        String name = "John";
        Optional<String> opt = Optional.ofNullable(name);

        assertEquals("John", opt.get());
    }

    private static void assertEquals(String str1, String str2) {
        if (str1.equals(str2)) {
            System.out.println("assertEquals true");
        }
    }

    /**
     * 这个方法会在值为 null 的时候抛出异常。要避免异常，你可以选择首先验证是否有值：
     */

    @Test
    public void whenCheckIfPresent_thenOk() {
        TestModel testModel = new TestModel("john@gmail.com", 1234L);
        Optional<TestModel> opt = Optional.ofNullable(testModel);
        assertTrue(opt.isPresent());
        assertEquals(testModel.getContext(), opt.get().getContext());
        opt.ifPresent(c -> System.out.println(c.getContext()));
        Optional<TestModel> opt1 = Optional.ofNullable(null);
        opt1.ifPresent(c -> System.out.println(c.getContext()));
    }

    private static void assertTrue(boolean present) {
        System.out.println("assertTrue " + present);
    }

    /**
     * 返回默认值 Optional 类提供了 API 用以返回对象值，或者在对象为空的时候返回默认值。
     * <p>
     * 这里你可以使用的第一个方法是 orElse()，它的工作方式非常直接，如果有值则返回该值，否则返回传递给它的参数值：
     */
    @Test
    public void whenEmptyValue_thenReturnDefault() {
        TestModel testModel = null;
        TestModel testModel2 = new TestModel("anna@gmail.com", 1234L);
        TestModel result = Optional.ofNullable(testModel).orElse(testModel2);

        assertEquals(testModel2.getContext(), result.getContext());
    }

    /**
     * orElse() 和 orElseGet() 的不同之处
     * <p>
     * 乍一看，这两种方法似乎起着同样的作用。然而事实并非如此。我们创建一些示例来突出二者行为上的异同。
     * <p>
     * 我们先来看看对象为空时他们的行为：
     */

    @Test
    public void givenEmptyValue_whenCompare_thenOk() {
        TestModel testModel = null;
        System.out.println("Using orElse");
        TestModel result = Optional.ofNullable(testModel).orElse(createNewTestModel());
        System.out.println("Using orElseGet");
        TestModel result2 = Optional.ofNullable(testModel).orElseGet(() -> createNewTestModel());
    }

    private TestModel createNewTestModel() {
        System.out.println("Creating New TestModel");
        return new TestModel("extra@gmail.com", 1234L);
    }

}
