package com.mytool.springModel;

import java.io.Serializable;
import java.util.Date;

/**
 * @author duankd
 * @ClassName CorpUser
 * @date 2021-01-27 22:37:21
 */
public class CorpUser implements Serializable {

    private static final long serialVersionUID = 5897434274704170856L;

    public  static final Long USER_ROLE_MANAGER = 1L;//超级管理员

    public static final Long USER_ROLE_FILEMAN = 2L;//公司文件管理员

    public static final  Long USER_ROLE_COMMON = 3L;//普通人员

    public static final Long USER_ROLE_AGENT = 4L;// 超管代理

    public static final Long USER_ROLE_PROVINCE = 5L;// 省份成员(针对集团统一目录)

    public static  final Long CORP_USER_STATUS_VALID = 1L;//企业用户状态 有效

    public static final Long CORP_USER_STATUS_INVALID = 0L;//企业用户状态 无效

    public static final Long CORP_USER_STATUS_LOCKED = 2L;//企业用户状态 锁定

    public static final Long CORP_USER_IS_NOT_HEAD=0L;//部门普通员工

    public static final  Long CORP_USER_IS_HEAD=1L;//部门负责人

    public static final Long HAS_WORK_YES = 1L;//有工作空间

    public static final Long HAS_WORK_NO =0L;// 无工作空间
    /**
     * 工作空间默认大小 单位字节
     */
    public static final Long DEFAULT_TOTAL_SIZE = 5368709120L;

    private Long id;

    private Long corpId;

    private Long userId;

    private String userName;

    private Long userRole;

    private String mobile;

    private String email;

    private Date createTime;

    private Date modifyTime;

    private Long status;

    private String position;

    private Long isHead;

    private Long hasWork;

    private Long usedSize;

    private Long totalSize;



    public Long getHasWork() {
        return hasWork;
    }

    public void setHasWork(Long hasWork) {
        this.hasWork = hasWork;
    }

    public Long getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(Long usedSize) {
        this.usedSize = usedSize;
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Long getUserRole() {
        return userRole;
    }

    public void setUserRole(Long userRole) {
        this.userRole = userRole;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }



    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getIsHead() {
        return isHead;
    }

    public void setIsHead(Long isHead) {
        this.isHead = isHead;
    }


    public Long getTotalSize() {
        /*if(totalSize == null) {
            totalSize = CorpUser.DEFAULT_TOTAL_SIZE;
        }*/
        return totalSize;

    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    @Override
    public String toString() {
        return "CorpUser{" +
                "id=" + id +
                ", corpId=" + corpId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userRole=" + userRole +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", status=" + status +
                ", position='" + position + '\'' +
                ", isHead=" + isHead +
                ", hasWork=" + hasWork +
                ", usedSize=" + usedSize +
                ", totalSize=" + totalSize +
                '}';
    }
}