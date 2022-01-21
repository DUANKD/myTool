package com.mytool.base.utils;

import org.junit.jupiter.api.Test;

/**
 * @author duankd
 * @ClassName PageUtil
 * @date 2022-01-06 17:11:02
 */
public class PageUtil {

    @Test
    void page() {
        int pageNum=1;
        int pageSize=22;
        int[] startEnd = cn.hutool.core.util.PageUtil.transToStartEnd(pageNum, pageSize);
        System.out.print("start: "+startEnd[0]+",end: "+startEnd[1]);
    }
}
