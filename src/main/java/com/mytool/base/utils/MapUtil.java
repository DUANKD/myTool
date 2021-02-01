package com.mytool.base.utils;

import com.mytool.springModel.SpringFestivalInviteUserVO;

import java.util.*;

/**
 * @author duankd
 * @ClassName MapUtil
 * @date 2021-01-22 10:48:35
 */
public class MapUtil {

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
}
