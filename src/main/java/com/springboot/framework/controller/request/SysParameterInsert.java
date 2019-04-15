package com.springboot.framework.controller.request;

public class SysParameterInsert {
    private String key;

    private String value;

    private String note;

    public SysParameterInsert() {
    }

    public SysParameterInsert(String key, String value, String note) {
        this.key = key;
        this.value = value;
        this.note = note;
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
