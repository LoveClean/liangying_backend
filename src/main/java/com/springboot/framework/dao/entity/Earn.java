package com.springboot.framework.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Earn {
    private Integer id;

    private String superiorId;

    private String subordinateId;

    private String subordinatePhone;

    private BigDecimal earnMoney;

    private BigDecimal loanMoney;

    private BigDecimal percentage;

    private String createBy;

    private Date createDate;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSuperiorId() {
        return superiorId;
    }

    public void setSuperiorId(String superiorId) {
        this.superiorId = superiorId == null ? null : superiorId.trim();
    }

    public String getSubordinateId() {
        return subordinateId;
    }

    public void setSubordinateId(String subordinateId) {
        this.subordinateId = subordinateId == null ? null : subordinateId.trim();
    }

    public String getSubordinatePhone() {
        return subordinatePhone;
    }

    public void setSubordinatePhone(String subordinatePhone) {
        this.subordinatePhone = subordinatePhone == null ? null : subordinatePhone.trim();
    }

    public BigDecimal getEarnMoney() {
        return earnMoney;
    }

    public void setEarnMoney(BigDecimal earnMoney) {
        this.earnMoney = earnMoney;
    }

    public BigDecimal getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(BigDecimal loanMoney) {
        this.loanMoney = loanMoney;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}