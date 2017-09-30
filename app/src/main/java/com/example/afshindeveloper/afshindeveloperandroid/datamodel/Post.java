package com.example.afshindeveloper.afshindeveloperandroid.datamodel;

import android.graphics.drawable.Drawable;

/**
 * Created by afshindeveloper on 22/08/2017.
 */

public class Post {
    private int id;
    private String postimageurl;

    private String title;
    private String content;
    private String date;
    private int isvisited=0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostimage() {
        return postimageurl;
    }

    public void setPostimage(String postimage) {
        this.postimageurl = postimage;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIsvisited() {
        return isvisited;
    }

    public void setIsvisited(int isvisited) {
        this.isvisited = isvisited;
    }
}
