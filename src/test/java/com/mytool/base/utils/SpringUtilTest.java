package com.mytool.base.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mytool.springModel.*;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import springfox.documentation.spring.web.json.Json;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SpringUtilTest {

    @Test
    void corpFileInviteEditListToVOList() {
        List<CorpFileInviteEdit> list = new ArrayList<>();
        {
            CorpFileInviteEdit inviteEdit = new CorpFileInviteEdit();
            List<SpringFestivalFileInviteVO> tempList = new ArrayList<>();
            {
                SpringFestivalFileInviteVO inviteVO = new SpringFestivalFileInviteVO();
                inviteVO.setUserId(1L);
                inviteVO.setName("aaa");
                inviteVO.setType(1);
                tempList.add(inviteVO);
            }
            {
                SpringFestivalFileInviteVO inviteVO = new SpringFestivalFileInviteVO();
                inviteVO.setUserId(2L);
                inviteVO.setName("ssss");
                inviteVO.setType(1);
                tempList.add(inviteVO);
            }
            {
                SpringFestivalFileInviteVO inviteVO = new SpringFestivalFileInviteVO();
                inviteVO.setUserId(3L);
                inviteVO.setName("ddd");
                inviteVO.setType(1);
                tempList.add(inviteVO);
            }
            {
                SpringFestivalFileInviteVO inviteVO = new SpringFestivalFileInviteVO();
                inviteVO.setUserId(4L);
                inviteVO.setName("ffff");
                inviteVO.setType(1);
                tempList.add(inviteVO);
            }
            {
                SpringFestivalFileInviteVO inviteVO = new SpringFestivalFileInviteVO();
                inviteVO.setUserId(5L);
                inviteVO.setName("gggg");
                inviteVO.setType(1);
                tempList.add(inviteVO);
            }
            {
                SpringFestivalFileInviteVO inviteVO = new SpringFestivalFileInviteVO();
                inviteVO.setUserId(6L);
                inviteVO.setName("hhhh");
                inviteVO.setType(1);
                tempList.add(inviteVO);
            }
            String str = JSONObject.toJSONString(tempList);
            inviteEdit.setUserIds(str);
            list.add(inviteEdit);
        }
        {
            CorpFileInviteEdit inviteEdit = new CorpFileInviteEdit();
            List<SpringFestivalFileInviteVO> tempList = new ArrayList<>();
            {
                SpringFestivalFileInviteVO inviteVO = new SpringFestivalFileInviteVO();
                inviteVO.setUserId(1L);
                inviteVO.setName("aaa");
                inviteVO.setType(2);
                tempList.add(inviteVO);
            }
            {
                SpringFestivalFileInviteVO inviteVO = new SpringFestivalFileInviteVO();
                inviteVO.setUserId(2L);
                inviteVO.setName("ssss");
                inviteVO.setType(1);
                tempList.add(inviteVO);
            }
            {
                SpringFestivalFileInviteVO inviteVO = new SpringFestivalFileInviteVO();
                inviteVO.setUserId(3L);
                inviteVO.setName("ddd");
                inviteVO.setType(1);
                tempList.add(inviteVO);
            }
            {
                SpringFestivalFileInviteVO inviteVO = new SpringFestivalFileInviteVO();
                inviteVO.setUserId(4L);
                inviteVO.setName("ffff");
                inviteVO.setType(1);
                tempList.add(inviteVO);
            }
            {
                SpringFestivalFileInviteVO inviteVO = new SpringFestivalFileInviteVO();
                inviteVO.setUserId(5L);
                inviteVO.setName("gggg");
                inviteVO.setType(1);
                tempList.add(inviteVO);
            }
            {
                SpringFestivalFileInviteVO inviteVO = new SpringFestivalFileInviteVO();
                inviteVO.setUserId(6L);
                inviteVO.setName("hhhh");
                inviteVO.setType(1);
                tempList.add(inviteVO);
            }
            String str = JSONObject.toJSONString(tempList);
            inviteEdit.setUserIds(str);
            list.add(inviteEdit);
        }
        List<SpringFestivalInviteUserVO> result = SpringUtil.corpFileInviteEditListToVOList(list);
        System.out.println(result);
    }

    @Test
    void returnVo() {
        List<SpringFestivalInviteUserVO> tempList = new ArrayList<>();
        {
            SpringFestivalInviteUserVO inviteVO = new SpringFestivalInviteUserVO();
            inviteVO.setInviteUserId(1L);
            inviteVO.setInviteUserName("aaa");
            inviteVO.setInviteUserNum(1);
            tempList.add(inviteVO);
        }
        {
            SpringFestivalInviteUserVO inviteVO = new SpringFestivalInviteUserVO();
            inviteVO.setInviteUserId(2L);
            inviteVO.setInviteUserName("ssss");
            inviteVO.setInviteUserNum(1);
            tempList.add(inviteVO);
        }
        {
            SpringFestivalInviteUserVO inviteVO = new SpringFestivalInviteUserVO();
            inviteVO.setInviteUserId(3L);
            inviteVO.setInviteUserName("ddd");
            inviteVO.setInviteUserNum(1);
            tempList.add(inviteVO);
        }
        {
            SpringFestivalInviteUserVO inviteVO = new SpringFestivalInviteUserVO();
            inviteVO.setInviteUserId(4L);
            inviteVO.setInviteUserName("ffff");
            inviteVO.setInviteUserNum(1);
            tempList.add(inviteVO);
        }
        {
            SpringFestivalInviteUserVO inviteVO = new SpringFestivalInviteUserVO();
            inviteVO.setInviteUserId(5L);
            inviteVO.setInviteUserName("gggg");
            inviteVO.setInviteUserNum(1);
            tempList.add(inviteVO);
        }
        {
            SpringFestivalInviteUserVO inviteVO = new SpringFestivalInviteUserVO();
            inviteVO.setInviteUserId(6L);
            inviteVO.setInviteUserName("hhhh");
            inviteVO.setInviteUserNum(1);
            tempList.add(inviteVO);
        }
        String str = JSONObject.toJSONString(tempList);


    }

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
        List<SpringFestivalInviteUserVO> result = SpringUtil.sortMap(map);
        System.out.println(result);
    }

    @Test
    void getRecordFromStr() {
        String str = "10000,0,1966,14,7,3,42,89,0";
        SpringFestivalDataVO dataVO = SpringUtil.getRecordFromStr(str);
        boolean flag = dataVO.isCompanyFlag();
        SpringFestivalRecord record = dataVO.transformToRecord();
        SpringFestivalCorp corp = dataVO.transformToCorp();
        String str1 = "0,1130731025123,0,0,0,0,539,75,1";
        SpringFestivalDataVO dataVO1 = SpringUtil.getRecordFromStr(str1);
        boolean flag1 = dataVO1.isCompanyFlag();
        SpringFestivalRecord record1 = dataVO1.transformToRecord();
        SpringFestivalCorp corp1 = dataVO1.transformToCorp();

        String mobile = getMobileFromDomainSpaceAccount("18988589602@189.cn");
        System.out.println(flag);
    }

    @Test
    void name() {
        String a = "段ddddddd达";
        String a1 = tuoMin(a);

        SecureRandom rnd = new SecureRandom();
        int b = rnd.nextInt(10);
        System.out.println(a1);
    }









    public static String tuoMin(String str) {
        if (StringUtils.isEmpty(str)) {
            throw new IllegalArgumentException("明文过短，无法脱敏");
        }
        int len = str.length() - 2;
        len = len > 1 ? len : 1;
        StringBuilder builder = new StringBuilder();
        builder.append(str.charAt(0));
        for (int i = 0; i < len; i++) {
            builder.append("*");
        }
        builder.append(str.charAt(str.length() - 1));
        return builder.toString();
    }

    /**
     * 获取手机号
     *
     * @param domainSpaceAccount
     * @return
     */
    public static String getMobileFromDomainSpaceAccount(String domainSpaceAccount) {
        if (StringUtils.isEmpty(domainSpaceAccount)) {
            return null;
        } else {
            //18988589602@189.cn
            int index = domainSpaceAccount.indexOf("@");
            if (index == 11) {
                String mobile = domainSpaceAccount.substring(0, index);
                return mobile;
            }
            return null;
        }

    }

    @Test
    void getCorpIdList() {
        List<CorpUser> tempList = new ArrayList<>();
        {
            CorpUser corpUser = new CorpUser();
            corpUser.setCorpId(1L);
            corpUser.setUserRole(1L);
            tempList.add(corpUser);
        }
        {
            CorpUser corpUser = new CorpUser();
            corpUser.setCorpId(1L);
            corpUser.setUserRole(2L);
            tempList.add(corpUser);
        }
        {
            CorpUser corpUser = new CorpUser();
            corpUser.setCorpId(1L);
            corpUser.setUserRole(3L);
            tempList.add(corpUser);
        }
        {
            CorpUser corpUser = new CorpUser();
            corpUser.setCorpId(1L);
            corpUser.setUserRole(4L);
            tempList.add(corpUser);
        }
        List<Long> result = SpringUtil.getCorpIdList(tempList);
        System.out.println(result);
    }
}