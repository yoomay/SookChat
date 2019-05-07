package com.example.sookchat;

public class Data {

    private String title;
    private String contents;


    public Data(String title, String contents) {
        this.title=title;
        this.contents=contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContent(String content) {
        this.contents = content;
    }

}