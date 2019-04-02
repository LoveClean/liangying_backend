package com.springboot.framework.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.framework.dao.entity.User;
import com.springboot.framework.dao.entity.Withdrawal;

import java.math.BigDecimal;
import java.util.Date;

public class WithdrawalListVO {
    private Integer id;
    private String userId;
    private BigDecimal money;
    private String createBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private Byte status;

    private String username;
    private String phone;

    public WithdrawalListVO() {
    }

    public WithdrawalListVO(Withdrawal withdrawal, User user) {
        this.id = withdrawal.getId();
        this.userId = withdrawal.getUserId();
        this.money = withdrawal.getMoney();
        this.createBy = withdrawal.getCreateBy();
        this.createDate = withdrawal.getCreateDate();
        this.updateBy = withdrawal.getUpdateBy();
        this.updateDate = withdrawal.getUpdateDate();
        this.status = withdrawal.getStatus();
        this.username = user.getUsername();
        this.phone = user.getPhone();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
