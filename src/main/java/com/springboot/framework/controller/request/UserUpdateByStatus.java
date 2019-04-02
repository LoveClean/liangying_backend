package com.springboot.framework.controller.request;

public class UserUpdateByStatus {
    private String id;
    private Byte status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
