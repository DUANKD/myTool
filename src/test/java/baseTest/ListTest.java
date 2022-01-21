package baseTest;

import com.mytool.model.TestModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duankd
 * @ClassName ListTest
 * @date 2021-03-11 14:49:24
 */
public class ListTest {
    @Test
    public void arrayListTest() {
        ArrayList<String> a1 = null;
        try {
            for (String s : a1) {
                System.out.println(s);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("for s");
        }
        try {
            for (int i = 0; i < a1.size(); i++) {
                System.out.println(a1.get(i));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("for i");
        }
        try {
            a1.forEach(s -> {
                System.out.println(s);
            });
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("forEach s");
        }

    }

    @Test
    public void arrayListValueTest() {
        ArrayList<TestModel> a = new ArrayList<>();
        ArrayList<TestModel> b = new ArrayList<>();
        {
            TestModel temp = new TestModel();
            temp.setContext("a");
            a.add(temp);
            a.add(temp);
            b.add(temp);
        }
        {
            TestModel temp = a.get(0);
            temp.setContext("bbb");
        }
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    void arrays() {
        int[] arrays = {1, 2};
        int[] arr1 = new int[]{12, 3, 4, 8, 5, 6, 6, 4};
        int[][] arrays1 = new int[1][];
        int[][] arrays2 = {{1, 2}, {2, 3, 4}, {3, 4, 5, 6}};
        Arrays.sort(arrays);
    }

    @Test
    void arrayssubList() {
        List<Integer> a = new ArrayList<>();
        a.addAll(Arrays.asList(12, 3, 4, 8, 5, 6, 6, 4));
        List<Integer> b = a.subList(1,8);
        System.out.println(b);
    }
}
