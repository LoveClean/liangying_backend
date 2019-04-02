package com.springboot.framework.dao.entity;

import java.util.Date;

public class LogUserLogin {
    private Integer id;

    private String remoteAddress;

    private String paramsPhone;

    private String requestParams;

    private String response;

    private String exception;

    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress == null ? null : remoteAddress.trim();
    }

    public String getParamsPhone() {
        return paramsPhone;
    }

    public void setParamsPhone(String paramsPhone) {
        this.paramsPhone = paramsPhone == null ? null : paramsPhone.trim();
    }

    public String getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams == null ? null : requestParams.trim();
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response == null ? null : response.trim();
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception == null ? null : exception.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}