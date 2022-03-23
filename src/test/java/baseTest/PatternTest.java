package baseTest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * <p>
 *
 * @author duankd/duankaida@bigo.sg
 * @version 1.0
 * @date 2022/3/16.
 */
public class PatternTest {
    @Test
    void name() {
        /**
         * 空格BIGO-baiguoyuan空格(手机名__app名__app版本__系统名__系统版本__外发or内测__设备id__用户id__appVersionCode)
         *
         */
        String iosUa = "Mozilla/5.0 (iPhone; CPU iPhone OS 12_3_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 BIGO-baiguoyuan (iPhone 7__bigolive__4.17.1000__iOS__12.3.1__1__03275a3f383831f662b0382f21398443__149876__124132)";
        String androidUa =
                "Mozilla/5.0 (Linux; Android 6.0.1; OPPO A57 Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/55.0.2883.91 Mobile Safari/537.36 BIGO-baiguoyuan (OPPO A57__bigolive__4.11.0__android__6.0.1__1__03275a3f383831f662b0382f21398443__149876__124132)";
        String uaRegex = " BIGO-baiguoyuan \\(([A-Za-z0-9_. ])+\\)";
        String bracketsRegex = "\\(([A-Za-z0-9_. ])+\\)";
        String paramsRegex = "([A-Za-z0-9. ])+";
        Matcher uaMatcher = Pattern.compile(uaRegex, Pattern.CASE_INSENSITIVE).matcher(androidUa);

        //Matcher matcher2 = Pattern.compile("([.])+", Pattern.CASE_INSENSITIVE).matcher("12.3.1__ ");
        //if (matcher2.find()) {
        //    System.out.println("matcher2:"+matcher2.group());
        //}


        List<String> paramList = new ArrayList<>();
        if (uaMatcher.find()) {
            String uaStr = uaMatcher.group();
            System.out.println("uaStr:" + uaMatcher.group());
            Matcher bracketsMatcher = Pattern.compile(bracketsRegex, Pattern.CASE_INSENSITIVE).matcher(uaStr);
            if (bracketsMatcher.find()) {
                String bracketsStr = bracketsMatcher.group();
                System.out.println("bracketsStr:" + bracketsStr);
                Matcher paramsMatcher = Pattern.compile(paramsRegex, Pattern.CASE_INSENSITIVE).matcher(bracketsStr);
                for (int i = 1; paramsMatcher.find(); i++) {
                    String paramsStr = paramsMatcher.group();
                    System.out.println("paramsStr-" + i + ":" + paramsStr);
                    paramList.add(paramsStr);
                }
            }
        }
        System.out.println("paramList:" + paramList);
    }
}
