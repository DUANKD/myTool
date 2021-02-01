package com.mytool.base.utils;

import com.alibaba.fastjson.JSON;
import com.mytool.springModel.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author duankd
 * @ClassName SpringUtil
 * @date 2021-01-22 10:56:32
 */
public class SpringUtil {

    /**
     * 处理 CorpFileInviteEdit 的用户字符串
     *
     * @param list
     * @return
     */
    public static List<SpringFestivalInviteUserVO> corpFileInviteEditListToVOList(List<CorpFileInviteEdit> list) {
        List<SpringFestivalInviteUserVO> voList = new ArrayList<>();
        if (list.isEmpty()) {
            return voList;
        }
        List<SpringFestivalFileInviteVO> temp = new ArrayList<>();
        List<SpringFestivalFileInviteVO> result = new ArrayList<>();

        for (CorpFileInviteEdit fileInviteEdit : list) {
            String userIds = fileInviteEdit.getUserIds();
            if (StringUtils.isEmpty(userIds)) {
                continue;
            }
            temp = JSON.parseArray(userIds, SpringFestivalFileInviteVO.class);

            if (!temp.isEmpty()) {
                for (SpringFestivalFileInviteVO inviteVO : temp) {
                    if (inviteVO.getUserId() != null && inviteVO.getType().equals(1)) {
                        result.add(inviteVO);
                    }
                }
            }
        }
        if (result.isEmpty()) {
            return voList;
        } else {
            Map<Long, SpringFestivalInviteUserVO> inviteUserVOMap = new HashMap<>();

            for (SpringFestivalFileInviteVO inviteVO : result) {
                Long userId = inviteVO.getUserId();
                if (inviteUserVOMap.containsKey(userId)) {
                    //增加
                    SpringFestivalInviteUserVO inviteUserVO = inviteUserVOMap.get(userId);
                    inviteUserVO.addInviteUserNum();
                } else {
                    //加入map
                    SpringFestivalInviteUserVO inviteUserVO = new SpringFestivalInviteUserVO();
                    inviteUserVO.setInviteUserId(userId);
                    inviteUserVO.setInviteUserName(inviteVO.getName());
                    inviteUserVO.setInviteUserNum(1);
                    inviteUserVOMap.put(userId, inviteUserVO);
                }
            }
            voList = sortMap(inviteUserVOMap);
        }


        return voList;
    }

    /**
     * map 排序
     * @param map
     * @return
     */
    public static List<SpringFestivalInviteUserVO> sortMap(Map<Long, SpringFestivalInviteUserVO> map) {

        //获取entrySet
        Set<Map.Entry<Long, SpringFestivalInviteUserVO>> mapEntries = map.entrySet();

        //使用链表来对集合进行排序，使用LinkedList，利于插入元素
        List<Map.Entry<Long, SpringFestivalInviteUserVO>> result = new LinkedList<>(mapEntries);
        //自定义比较器来比较链表中的元素
        Collections.sort(result, new Comparator<Map.Entry<Long, SpringFestivalInviteUserVO>>() {
            //基于entry的值（Entry.getValue()），来排序链表
            @Override
            public int compare(Map.Entry<Long, SpringFestivalInviteUserVO> o1, Map.Entry<Long, SpringFestivalInviteUserVO> o2) {
                return o2.getValue().getInviteUserNum().compareTo(o1.getValue().getInviteUserNum());
            }
        });

        //将排好序的存入到LinkedHashMap(可保持顺序)中，需要存储键和值信息对到新的映射中。
        Integer sort = 1;
        List<SpringFestivalInviteUserVO> inviteUserVOList = new ArrayList<>();
        for (Map.Entry<Long, SpringFestivalInviteUserVO> newEntry : result) {
            // 取出排名前5的值
            if (sort <= 5) {
                inviteUserVOList.add(newEntry.getValue());
                ++sort;
            }
        }
        return inviteUserVOList;
    }


    //user_id,corp_id,login_num,share_num,invite_num,max_working_time_window,upload_num,download_num,company_flag
    public static SpringFestivalDataVO getRecordFromStr(String str) {
        try {
            String[] strs = str.split(",");
            SpringFestivalDataVO dataVO = new SpringFestivalDataVO();
            dataVO.setUserId(strs[0]);
            dataVO.setCorpId(strs[1]);
            dataVO.setLoginNum(strs[2]);
            dataVO.setShareNum(strs[3]);
            dataVO.setInviteNum(strs[4]);
            dataVO.setMaxWorkingTimeWindow(strs[5]);
            dataVO.setUploadNum(strs[6]);
            dataVO.setDownloadNum(strs[7]);
            dataVO.setCompanyFlag(strs[8]);
            return dataVO;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * @param inviteUserVOList
     * @return
     */
    public static String getInviteUserStr(List<SpringFestivalInviteUserVO> inviteUserVOList) {
        if (CollectionUtils.isNotEmpty(inviteUserVOList)) {
            StringBuffer sb = new StringBuffer();
            for (SpringFestivalInviteUserVO userVO : inviteUserVOList) {
                sb.append(userVO.getInviteUserId());
                sb.append(",");
                sb.append(userVO.getInviteUserName());
                sb.append(",");
                sb.append(userVO.getInviteUserNum());
                sb.append("+");
            }
            return sb.toString();
        }
        return null;
    }

    public static List<SpringFestivalInviteUserVO> getInviteUserList(String str) {
        if (StringUtils.isNotEmpty(str)) {
            List<SpringFestivalInviteUserVO> list = new ArrayList<>();
            String[] strings = str.split("\\+");
            for (String userVOStr : strings) {
                String[] temps = userVOStr.split(",");
                SpringFestivalInviteUserVO vo = new SpringFestivalInviteUserVO();
                vo.setInviteUserId(Long.valueOf(temps[0]));
                vo.setInviteUserName(String.valueOf(temps[1]));
                vo.setInviteUserNum(Integer.valueOf(temps[2]));
                list.add(vo);
            }
            return list;
        }
        return null;
    }



    /**
     * 返回角色为1、4的公司id
     *
     * @param corpUserList
     * @return
     */
    public static List<Long> getCorpIdList(List<CorpUser> corpUserList) {
        List<Long> corpIdList = new ArrayList<>();
        if (CollectionUtils.isEmpty(corpUserList)) {
            return corpIdList;
        }
        for (CorpUser corpUser : corpUserList) {
            Long userRole = corpUser.getUserRole();
            Long corpId = corpUser.getCorpId();
            //判断角色 1、4
            if (userRole==1L || userRole==4L) {
                //判断公司id是否正常
                if (corpId != null && corpId > 0) {
                    corpIdList.add(corpId);
                }
            }
        }
        return corpIdList;
    }
}
