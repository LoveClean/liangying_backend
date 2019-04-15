package com.springboot.framework.controller.request;

public class SysParameterUpdate {
    private Integer id;

    private String key;

    private String value;

    private String note;

    public SysParameterUpdate() {
    }

    public SysParameterUpdate(Integer id, String key, String value, String note) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
