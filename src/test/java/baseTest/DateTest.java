package baseTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mytool.base.utils.SpringUtil;
import com.mytool.springModel.SpringFestivalInviteUserVO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author duankd
 * @ClassName DateTest
 * @date 2021-01-21 14:45:15
 */
public class DateTest {
    @Test
    void name() {
        Date firstCreateTime = new Date(1609430399000L);
        System.out.println(firstCreateTime);
        Date BEGIN_DATE = new Date(1577808000000L);
        System.out.println(firstCreateTime.after(BEGIN_DATE));
        Date date = new Date();
        System.out.println(firstCreateTime.after(date));
    }

    @Test
    void name1() {
        List<SpringFestivalInviteUserVO> inviteUserVOList = new ArrayList<>();
        {
            SpringFestivalInviteUserVO inviteUserVO = new SpringFestivalInviteUserVO();
            inviteUserVO.setInviteUserId(123L);
            inviteUserVO.setInviteUserName("张*三");
            inviteUserVO.setInviteUserNum(123);
            inviteUserVOList.add(inviteUserVO);
        }

        {
            SpringFestivalInviteUserVO inviteUserVO = new SpringFestivalInviteUserVO();
            inviteUserVO.setInviteUserId(13L);
            inviteUserVO.setInviteUserName("王*三");
            inviteUserVO.setInviteUserNum(155);
            inviteUserVOList.add(inviteUserVO);
        }
        {
            SpringFestivalInviteUserVO inviteUserVO = new SpringFestivalInviteUserVO();
            inviteUserVO.setInviteUserId(13L);
            inviteUserVO.setInviteUserName("王*三");
            inviteUserVO.setInviteUserNum(155);
            inviteUserVOList.add(inviteUserVO);
        }
        {
            SpringFestivalInviteUserVO inviteUserVO = new SpringFestivalInviteUserVO();
            inviteUserVO.setInviteUserId(13L);
            inviteUserVO.setInviteUserName("王*三");
            inviteUserVO.setInviteUserNum(155);
            inviteUserVOList.add(inviteUserVO);
        }
        {
            SpringFestivalInviteUserVO inviteUserVO = new SpringFestivalInviteUserVO();
            inviteUserVO.setInviteUserId(13L);
            inviteUserVO.setInviteUserName("王*三");
            inviteUserVO.setInviteUserNum(155);
            inviteUserVOList.add(inviteUserVO);
        }


        /*String inviteUsers = JSON.toJSONString(inviteUserVOList);
        System.out.println(inviteUsers);

        String str = "[{\"id\":null,\"type\":1,\"name\":\"小赖\"},{\"id\":15322,\"type\":1,\"name\":\"邓小俊\"},{\"id\":14202,\"type\":1,\"name\":\"邓文俊\"}]";
        JSONArray array = JSON.parseArray(str);
        if (array.size() > 0) {
            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                Long userId = jsonObject.getLong("id");
                String name = jsonObject.getString("name");
                Integer type = jsonObject.getInteger("type");
                System.out.println("" + userId + name + type);
            }
        }
        System.out.println(array.size());*/

        String inviteUsers = SpringUtil.getInviteUserStr(inviteUserVOList);
        List<SpringFestivalInviteUserVO> list = SpringUtil.getInviteUserList(inviteUsers);
        System.out.println(list);
    }
}
