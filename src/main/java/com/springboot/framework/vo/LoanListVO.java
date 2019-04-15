package com.springboot.framework.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.framework.dao.entity.Loan;
import com.springboot.framework.dao.entity.User;

import java.math.BigDecimal;
import java.util.Date;

public class LoanListVO {
    private Integer id;
    private String userId;
    private BigDecimal money;
    private String houseType;
    private String carType;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private Byte status;

    private String username;
    private String phone;

    public LoanListVO() {
    }

    public LoanListVO(Loan record, User record3) {
        this.id = record.getId();
        this.userId = record.getUserId();
        this.money = record.getMoney();
//        this.houseType = record.getHouseType();
        switch (record.getHouseType()) {
            case 1:
                this.houseType = "商品房-无贷款";
                break;
            case 2:
                this.houseType = "商品房-有贷款";
                break;
            case 3:
                this.houseType = "其他房产";
                break;
            case 4:
                this.houseType = "无房产";
                break;
            default:
                this.houseType = "未填写";
                break;
        }
//        this.carType = record.getCarType();
        switch (record.getCarType()) {
            case 1:
                this.carType = "全款车";
                break;
            case 2:
                this.carType = "贷款车";
                break;
            case 3:
                this.carType = "无车";
                break;
            default:
                this.carType = "未填写";
                break;
        }
        this.createBy = record.getCreateBy();
        this.createDate = record.getCreateDate();
        this.updateBy = record.getUpdateBy();
        this.updateDate = record.getUpdateDate();
        this.status = record.getStatus();
        this.username = record3.getUsername();
        this.phone = record3.getPhone();
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

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
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
