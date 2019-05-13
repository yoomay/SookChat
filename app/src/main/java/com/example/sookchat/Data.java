package com.example.sookchat;

public class Data {

    private int catid;
    private String title;
    private String content;

    public Data(int catid, String title, String content) {
        this.catid = catid;
        this.title = title;
        this.content = content;
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}