package com.mytool.base.utils;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MapUtilTest {

    @Test
    void sortMap() {
        Map<Long, String> map = new HashMap<>();
        {
            String inviteUserVO = "sdasd";
            map.put(1L, inviteUserVO);
        }

        List<String> result= MapUtil.sortMap(map);
        System.out.println(result);
    }
}