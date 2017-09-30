package com.example.afshindeveloper.afshindeveloperandroid.datamodel;

import android.graphics.drawable.Drawable;

/**
 * Created by afshindeveloper on 30/08/2017.
 */

public class Clothe {
    private int id;
    private Drawable image;
    private String title;
    private int viewcount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getViewcount() {
        return viewcount;
    }

    public void setViewcount(int viewcount) {
        this.viewcount = viewcount;
    }
}
