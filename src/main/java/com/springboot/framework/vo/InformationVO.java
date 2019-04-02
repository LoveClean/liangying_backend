package com.springboot.framework.vo;

import com.springboot.framework.dao.entity.Information;
import com.springboot.framework.dao.entity.InformationInfo;

public class InformationVO {
    private Integer id;
    private String title;
    private String cover;
    private String category;
    private String introduction;
    private Integer read;
    private Integer like;
    private String picture;
    private String content;

    public InformationVO() {
    }

    public InformationVO(Information record, InformationInfo record2) {
        this.id = record.getId();
        this.title = record.getTitle();
        this.cover = record.getCover();
        this.category = record.getCategory();
        this.introduction = record.getIntroduction();
        this.read = record.getRead();
        this.like = record.getLike();
        this.picture = record2.getPicture();
        this.content = record2.getContent();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
