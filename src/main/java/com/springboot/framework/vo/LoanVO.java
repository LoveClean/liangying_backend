package com.springboot.framework.vo;

import com.springboot.framework.dao.entity.Loan;
import com.springboot.framework.dao.entity.LoanInfo;
import com.springboot.framework.dao.entity.User;

import java.math.BigDecimal;

public class LoanVO {
    private Integer id;
    private String userId;
    private BigDecimal money;
    private Byte houseType;
    private Byte carType;

    private String houseLocation;
    private Byte houseMaster;
    private String houseTime;
    private String houseMonthlyAmount;
    private String carLocation;
    private String carYear;
    private String carMonthlyAmount;
    private String houseFile;
    private String carFile;

    private String username;
    private String phone;

    public LoanVO() {
    }

    public LoanVO(Loan record, LoanInfo record2, User record3) {
        this.id = record.getId();
        this.userId = record.getUserId();
        this.money = record.getMoney();
        this.houseType = record.getHouseType();
        this.carType = record.getCarType();
        this.houseLocation = record2.getHouseLocation();
        this.houseMaster = record2.getHouseMaster();
        this.houseTime = record2.getHouseTime();
        this.houseMonthlyAmount = record2.getHouseMonthlyAmount();
        this.carLocation = record2.getCarLocation();
        this.carYear = record2.getCarYear();
        this.carMonthlyAmount = record2.getCarMonthlyAmount();
        this.houseFile = record2.getHouseFile();
        this.carFile = record2.getCarFile();
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

    public Byte getHouseType() {
        return houseType;
    }

    public void setHouseType(Byte houseType) {
        this.houseType = houseType;
    }

    public Byte getCarType() {
        return carType;
    }

    public void setCarType(Byte carType) {
        this.carType = carType;
    }

    public String getHouseLocation() {
        return houseLocation;
    }

    public void setHouseLocation(String houseLocation) {
        this.houseLocation = houseLocation;
    }

    public Byte getHouseMaster() {
        return houseMaster;
    }

    public void setHouseMaster(Byte houseMaster) {
        this.houseMaster = houseMaster;
    }

    public String getHouseTime() {
        return houseTime;
    }

    public void setHouseTime(String houseTime) {
        this.houseTime = houseTime;
    }

    public String getHouseMonthlyAmount() {
        return houseMonthlyAmount;
    }

    public void setHouseMonthlyAmount(String houseMonthlyAmount) {
        this.houseMonthlyAmount = houseMonthlyAmount;
    }

    public String getCarLocation() {
        return carLocation;
    }

    public void setCarLocation(String carLocation) {
        this.carLocation = carLocation;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public String getCarMonthlyAmount() {
        return carMonthlyAmount;
    }

    public void setCarMonthlyAmount(String carMonthlyAmount) {
        this.carMonthlyAmount = carMonthlyAmount;
    }

    public String getHouseFile() {
        return houseFile;
    }

    public void setHouseFile(String houseFile) {
        this.houseFile = houseFile;
    }

    public String getCarFile() {
        return carFile;
    }

    public void setCarFile(String carFile) {
        this.carFile = carFile;
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
