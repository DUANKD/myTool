package com.mytool.model;

import lombok.Data;

/**
 * <p>活动中心返回对象
 * <p>
 *
 * @author duankd/duankaida@bigo.sg
 * @version 1.0
 * @date 2022/3/14.
 */
@Data
public class ActCenterResultVO {
    /* 活动名称*/
    private String name;
    /* 活动链接*/
    private String link;
    /* 活动摘要*/
    private String summary;
    /* 活动图标*/
    private String icon;
    /* 开始时间戳，格式为Unix 时间戳，长度为10位*/
    private Long startTime;
    /* 结束时间戳，格式为Unix 时间戳，长度为10位*/
    private Long endTime;
    /* 最小版本*/
    private Integer minVersion;
    /* 榜单*/
    private Long rank;
}
