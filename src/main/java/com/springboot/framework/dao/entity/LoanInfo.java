package com.springboot.framework.dao.entity;

public class LoanInfo {
    private Integer loanId;

    private String houseLocation;

    private Byte houseMaster;

    private String houseTime;

    private String houseMonthlyAmount;

    private String carLocation;

    private String carYear;

    private String carMonthlyAmount;

    private String houseFile;

    private String carFile;

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public String getHouseLocation() {
        return houseLocation;
    }

    public void setHouseLocation(String houseLocation) {
        this.houseLocation = houseLocation == null ? null : houseLocation.trim();
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
        this.houseTime = houseTime == null ? null : houseTime.trim();
    }

    public String getHouseMonthlyAmount() {
        return houseMonthlyAmount;
    }

    public void setHouseMonthlyAmount(String houseMonthlyAmount) {
        this.houseMonthlyAmount = houseMonthlyAmount == null ? null : houseMonthlyAmount.trim();
    }

    public String getCarLocation() {
        return carLocation;
    }

    public void setCarLocation(String carLocation) {
        this.carLocation = carLocation == null ? null : carLocation.trim();
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear == null ? null : carYear.trim();
    }

    public String getCarMonthlyAmount() {
        return carMonthlyAmount;
    }

    public void setCarMonthlyAmount(String carMonthlyAmount) {
        this.carMonthlyAmount = carMonthlyAmount == null ? null : carMonthlyAmount.trim();
    }

    public String getHouseFile() {
        return houseFile;
    }

    public void setHouseFile(String houseFile) {
        this.houseFile = houseFile == null ? null : houseFile.trim();
    }

    public String getCarFile() {
        return carFile;
    }

    public void setCarFile(String carFile) {
        this.carFile = carFile == null ? null : carFile.trim();
    }
}