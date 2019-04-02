package com.springboot.framework.dao.entity;

public class UserInfo {
    private String userId;

    private Byte profession;

    private Byte accumulationFund;

    private Byte socialSecurity;

    private Byte commercialInsurance;

    private String credit;

    private String idFront;

    private String idBack;

    private String bind;

    private String loanOfficerFile;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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
        this.credit = credit == null ? null : credit.trim();
    }

    public String getIdFront() {
        return idFront;
    }

    public void setIdFront(String idFront) {
        this.idFront = idFront == null ? null : idFront.trim();
    }

    public String getIdBack() {
        return idBack;
    }

    public void setIdBack(String idBack) {
        this.idBack = idBack == null ? null : idBack.trim();
    }

    public String getBind() {
        return bind;
    }

    public void setBind(String bind) {
        this.bind = bind == null ? null : bind.trim();
    }

    public String getLoanOfficerFile() {
        return loanOfficerFile;
    }

    public void setLoanOfficerFile(String loanOfficerFile) {
        this.loanOfficerFile = loanOfficerFile == null ? null : loanOfficerFile.trim();
    }
}