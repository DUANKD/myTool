package baseTest;

import com.mytool.model.TestModel;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author duankd
 * @ClassName MapTest
 * @date 2020-12-11 9:34:43
 */
public class StringTest {

    private static String testStr = "aaa";


    @Test
    public void transferTest() {
        String testStr1 = "aaa";
        changeStr(testStr1);
        System.out.println(testStr1);
        TestModel testModel = new TestModel();
        testModel.setContext("testStr");
        changeTestModel(testModel);
        System.out.println(testModel.getContext());
    }

    @Test
    public void splice() {
        String testStr1 = "aaa";
        TestModel testModel = new TestModel();
        testModel.setContext("testStr");
        testModel.setLongNumber(null);
        Date date = null;
        Date date1 = new Date();
        StringBuilder sb = new StringBuilder();
        //sb.append(testModel.getContext());
        //sb.append("\\t");
        //sb.append(testModel.getLongNumber());
        //sb.append("\\t");
        //sb.append(testModel.getLongNumber());
        //sb.append("\\t");
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sb.append(date == null ? "" : dFormat.format(date));
        sb.append("\\t");
        sb.append(dFormat.format(date1));
        sb.append("\\t");
        System.out.println(sb.toString().replace("null", ""));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("aaa");
        String str = stringBuffer.toString();
    }

    private static String changeStr(String str) {
        str = "bbbb";
        return str;
    }

    private static void changeTestModel(TestModel testModel) {
        testModel.setContext("bbbb");
    }

    @Test
    public void replace() {
        String a = "We are family";
        String b = a.replace(" ", "%20");
        System.out.println(b);
    }

    @Test
    public void transferIntTest() {
        String rights = "111111111111";
        long intNum = Long.parseLong(rights);
        long result = intNum | 0b000000000000;
        System.out.println(result);
        Long a = null;
        String aStr = StringUtils.defaultIfEmpty(""+a, "aaa");
        System.out.println(aStr);
    }

    @Test
    public void forcedConversion() {
        Integer a = 255;
        Object b = a;
        String c1 = (String) b;
        String c2 = a.toString();
        String c3 = b.toString();
        System.out.println(c2);
    }

    @Test
    public void subString() {
        String a = "abcdef";
        String b = a.substring(0, 1);
        String c = a.substring(6 - 2, 6);
        System.out.println(a);
    }

    @Test
    public void name1() {
        String header = "JSESSIONID=aaa1V58iTkG_d8_fEhMRx; path=/";
        String result = String.format("%s; %s", header, "SameSite=None; Secure;");
        System.out.println(result);
    }

    @Test
    public void name2() {
        String cookieStr = "Cookie[JSESSIONID=aaaXvbOrHb-hh9_18aNRx]";
        String result = cookieStr.substring(cookieStr.indexOf("[") + 1, cookieStr.lastIndexOf("]"));
        System.out.println(result);
    }

    @Test
    public void arrayContain() {
        String[] uris = {"abc[2]", "abc", "[2]"};
        String uri = "abc";
        boolean result = ArrayUtils.contains(uris, uri);
        int index = ArrayUtils.indexOf(uris, uri);
        System.out.printf("结果%s %d\n", result, index);
    }

    @Test
    public void transfer() {
        String s="begin";
        change(s);
        System.out.println(s);
    }

    private void change(String s){
        //s="change";
        s=new String("change new");
    }
}
