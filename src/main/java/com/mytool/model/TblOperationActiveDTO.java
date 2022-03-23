package com.mytool.model;

import lombok.Data;

import java.util.Date;

@Data
public class TblOperationActiveDTO {
    private Integer id;
    private String name;
    private String link;
    private String icon;
    private Integer type;
    private Integer platform;
    private Date startTime;
    private Date endTime;
    private Integer minVersion;
    private Long rank;
    private Long createTime;
    private Long modifyTime;
    private Integer channelId;
    private Integer applyUser;
    private String summary;
}
