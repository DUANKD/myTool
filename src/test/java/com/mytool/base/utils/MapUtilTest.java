package com.mytool.base.utils;

import com.mytool.springModel.SpringFestivalInviteUserVO;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MapUtilTest {

    @Test
    void sortMap() {
        Map<Long, SpringFestivalInviteUserVO> map = new HashMap<>();
        {
            SpringFestivalInviteUserVO inviteUserVO = new SpringFestivalInviteUserVO();
            inviteUserVO.setInviteUserId(103L);
            inviteUserVO.setInviteUserName("张*三");
            inviteUserVO.setInviteUserNum(103);
            map.put(inviteUserVO.getInviteUserId(), inviteUserVO);
        }

        {
            SpringFestivalInviteUserVO inviteUserVO = new SpringFestivalInviteUserVO();
            inviteUserVO.setInviteUserId(113L);
            inviteUserVO.setInviteUserName("王*三");
            inviteUserVO.setInviteUserNum(115);
            map.put(inviteUserVO.getInviteUserId(), inviteUserVO);
        }
        {
            SpringFestivalInviteUserVO inviteUserVO = new SpringFestivalInviteUserVO();
            inviteUserVO.setInviteUserId(123L);
            inviteUserVO.setInviteUserName("王*三");
            inviteUserVO.setInviteUserNum(125);
            map.put(inviteUserVO.getInviteUserId(), inviteUserVO);
        }
        {
            SpringFestivalInviteUserVO inviteUserVO = new SpringFestivalInviteUserVO();
            inviteUserVO.setInviteUserId(133L);
            inviteUserVO.setInviteUserName("王*三");
            inviteUserVO.setInviteUserNum(135);
            map.put(inviteUserVO.getInviteUserId(), inviteUserVO);
        }
        {
            SpringFestivalInviteUserVO inviteUserVO = new SpringFestivalInviteUserVO();
            inviteUserVO.setInviteUserId(143L);
            inviteUserVO.setInviteUserName("王*三");
            inviteUserVO.setInviteUserNum(145);
            map.put(inviteUserVO.getInviteUserId(), inviteUserVO);
        }
        {
            SpringFestivalInviteUserVO inviteUserVO = new SpringFestivalInviteUserVO();
            inviteUserVO.setInviteUserId(153L);
            inviteUserVO.setInviteUserName("王*三");
            inviteUserVO.setInviteUserNum(155);
            map.put(inviteUserVO.getInviteUserId(), inviteUserVO);
        }
        List<SpringFestivalInviteUserVO> result= MapUtil.sortMap(map);
        System.out.println(result);
    }
}