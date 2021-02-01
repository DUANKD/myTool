package com.mytool.springModel;

import java.util.Date;

/**
 * @author duankd
 * @ClassName CorpFileInviteEdit
 * @date 2021-01-22 10:57:54
 */

public class CorpFileInviteEdit {

    /**
     * 有效状态
     */
    public static final int STATUS_EFFECTIVE = 0;
    /**
     * 无效状态
     */
    public static final int STATUS_INVALID = 1;
    /**
     * 删除状态
     */
    public static final int STATUS_DELETE = 2;


    private Long id;

    private Long corpId;

    private Long userId;

    private Long fileId;

    private Date effectiveTime;

    private Integer status;

    private String outsideUserMobiles;

    private Date createTime;

    private Date updateTime;

    private String userIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCorpId() {
        return corpId;
    }

    public void setCorpId(Long corpId) {
        this.corpId = corpId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOutsideUserMobiles() {
        return outsideUserMobiles;
    }

    public void setOutsideUserMobiles(String outsideUserMobiles) {
        this.outsideUserMobiles = outsideUserMobiles == null ? null : outsideUserMobiles.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds == null ? null : userIds.trim();
    }

    @Override
    public String toString() {
        return "CorpFileInviteEdit{" +
                "id=" + id +
                ", corpId=" + corpId +
                ", userId=" + userId +
                ", fileId=" + fileId +
                ", effectiveTime=" + effectiveTime +
                ", status=" + status +
                ", outsideUserMobiles='" + outsideUserMobiles + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userIds='" + userIds + '\'' +
                '}';
    }
}
