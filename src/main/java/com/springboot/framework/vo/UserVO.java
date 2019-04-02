package com.springboot.framework.vo;

import com.springboot.framework.dao.entity.User;
import com.springboot.framework.dao.entity.UserInfo;

import java.math.BigDecimal;
import java.util.Date;

public class UserVO {
    private String id;
    private String username;
    private String phone;
    private String password;
    private String idNumber;
    private String wechat;
    private String userId;
    private Integer inviteNumber;
    private BigDecimal earn;
    private BigDecimal balance;
    private Date createDate;
    private Byte status;
    private Byte profession;
    private Byte accumulationFund;
    private Byte socialSecurity;
    private Byte commercialInsurance;
    private String credit;
    private String idFront;
    private String idBack;
    private String bind;
    private String loanOfficerFile;

    public UserVO() {
    }

    public UserVO(User record, UserInfo record2) {
        this.id = record.getId();
        this.username = record.getUsername();
        this.phone = record.getPhone();
        this.password = record.getPassword();
        this.idNumber = record.getIdNumber();
        this.wechat = record.getWechat();
        this.userId = record.getUserId();
        this.inviteNumber = record.getInviteNumber();
        this.earn = record.getEarn();
        this.balance = record.getBalance();
        this.createDate = record.getCreateDate();
        this.status = record.getStatus();
        this.profession = record2.getProfession();
        this.accumulationFund = record2.getAccumulationFund();
        this.socialSecurity = record2.getSocialSecurity();
        this.commercialInsurance = record2.getCommercialInsurance();
        this.credit = record2.getCredit();
        this.idFront = record2.getIdFront();
        this.idBack = record2.getIdBack();
        this.bind = record2.getBind();
        this.loanOfficerFile = record2.getLoanOfficerFile();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getInviteNumber() {
        return inviteNumber;
    }

    public void setInviteNumber(Integer inviteNumber) {
        this.inviteNumber = inviteNumber;
    }

    public BigDecimal getEarn() {
        return earn;
    }

    public void setEarn(BigDecimal earn) {
        this.earn = earn;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Byte getProfession() {
        return profession;
    }

    public void setProfession(Byte profession) {
        this.profession = profession;
    }

    public Byte getAccumulationFund() {
        return accumulationFund;
    }

    public void setAccumulationFund(Byte accumulationFund) {
        this.accumulationFund = accumulationFund;
    }

    public Byte getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(Byte socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public Byte getCommercialInsurance() {
        return commercialInsurance;
    }

    public void setCommercialInsurance(Byte commercialInsurance) {
        this.commercialInsurance = commercialInsurance;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getIdFront() {
        return idFront;
    }

    public void setIdFront(String idFront) {
        this.idFront = idFront;
    }

    public String getIdBack() {
        return idBack;
    }

    public void setIdBack(String idBack) {
        this.idBack = idBack;
    }

    public String getBind() {
        return bind;
    }

    public void setBind(String bind) {
        this.bind = bind;
    }

    public String getLoanOfficerFile() {
        return loanOfficerFile;
    }

    public void setLoanOfficerFile(String loanOfficerFile) {
        this.loanOfficerFile = loanOfficerFile;
    }
}
