package com.mytool.base.utils;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import com.mytool.springModel.SpringFestivalInviteUserVO;
import com.mytool.springModel.SpringFestivalRecord;
import com.mytool.springModel.SpringFestivalRecordVO;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author duankd
 * @ClassName BeanUtilTest
 * @date 2021-01-21 12:16:15
 */
public class BeanUtilTest {

    @Test
    void name() {
        double a = 13897.83;
        double b = 1389783;
        double c = a / b;
        BigDecimal bigDecimal = new BigDecimal(c).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal bigDecimal1 = new BigDecimal("0.09").setScale(2, BigDecimal.ROUND_HALF_UP);
        if (bigDecimal.equals(bigDecimal1)) {
            System.out.println("equal");
        }
        if (bigDecimal.compareTo(bigDecimal1) == -1) {
            System.out.println("小于");
        }
        if (bigDecimal.compareTo(bigDecimal1) == 0) {
            System.out.println("等于");
        }
        if (bigDecimal.compareTo(bigDecimal1) == 1) {
            System.out.println("大于");
        }
        SpringFestivalRecord springFestivalRecord = new SpringFestivalRecord();
        springFestivalRecord.setUserId(1L);
        springFestivalRecord.setFirstCorpId(1L);
        springFestivalRecord.setCreateTime(new Date());
        springFestivalRecord.setJoinNo(55);
        springFestivalRecord.setJoinRate(bigDecimal);
        springFestivalRecord.setLoginNum(55);
        springFestivalRecord.setLoginNo(5);
        springFestivalRecord.setLoginRate(bigDecimal);
        springFestivalRecord.setShareNum(7);
        springFestivalRecord.setInviteNum(10);

        {
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
            springFestivalRecord.setInviteUserIds(str);
        }

        springFestivalRecord.setMaxWorkingTimeWindow(1);
        springFestivalRecord.setUploadNum(100);
        springFestivalRecord.setDownloadNum(400);
        springFestivalRecord.setUploadDownloadNum(500);
        springFestivalRecord.setUploadDownloadNo(5);
        springFestivalRecord.setUploadDownloadRate(bigDecimal);
        springFestivalRecord.setAdminFlag(41554L);

        SpringFestivalRecordVO recordVO = new SpringFestivalRecordVO();
        BeanUtil.copyProperties(springFestivalRecord, recordVO);
        if (springFestivalRecord.getAdminFlag() > 0) {
            recordVO.setAdminFlag(true);
        } else {
            recordVO.setAdminFlag(false);
        }

        if (StringUtils.isEmpty(springFestivalRecord.getInviteUserIds())) {
            recordVO.setInviteUsers(null);
        } else {
            List<SpringFestivalInviteUserVO> inviteUsers = JSONObject.parseArray(springFestivalRecord.getInviteUserIds(), SpringFestivalInviteUserVO.class);
            recordVO.setInviteUsers(inviteUsers);
        }
        recordVO.setKeywordFlag(1);

        System.out.println(recordVO);
    }


    @Test
    void name1() {
        double a = 1389782;
        double b = 1389783;
        double c = a / b;
        BigDecimal bigDecimal = new BigDecimal(c).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal bigDecimal1 = getBigDecimal(bigDecimal);
        System.out.println(bigDecimal1);
    }

    private static BigDecimal minBigDecimal = new BigDecimal("0.01").setScale(2, BigDecimal.ROUND_HALF_UP);
    private static BigDecimal halfBigDecimal = new BigDecimal("0.5").setScale(2, BigDecimal.ROUND_HALF_UP);
    private static BigDecimal maxBigDecimal = new BigDecimal("0.99").setScale(2, BigDecimal.ROUND_HALF_UP);

    static BigDecimal getBigDecimal(BigDecimal bigDecimal) {
        if (bigDecimal.compareTo(minBigDecimal) == -1) {
            return minBigDecimal;
        } else if (bigDecimal.compareTo(maxBigDecimal) == 1) {
            return maxBigDecimal;
        } else {
            return bigDecimal;
        }
    }
}
