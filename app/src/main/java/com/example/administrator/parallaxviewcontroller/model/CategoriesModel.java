package com.example.administrator.parallaxviewcontroller.model;

/**
 * @author wangchengm
 * @更新时间 2015 11 15
 */
public class CategoriesModel {
    private String title;
    private int    coverUrl;

    public int getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(int coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
