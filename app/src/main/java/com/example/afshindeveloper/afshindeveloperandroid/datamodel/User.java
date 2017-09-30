package com.example.afshindeveloper.afshindeveloperandroid.datamodel;

/**
 * Created by afshindeveloper on 10/09/2017.
 */

public class User {
    private String first_name ="";
    private String last_name ="";
    private boolean isHtmlExpert=false;
    private boolean isCssExpert=false;
    private boolean isJavaExpert=false;
    public static final byte male=0;
    public static final byte female=1;
    private byte gender=male;


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public boolean isHtmlExpert() {
        return isHtmlExpert;
    }

    public void setHtmlExpert(boolean htmlExpert) {
        isHtmlExpert = htmlExpert;
    }

    public boolean isCssExpert() {
        return isCssExpert;
    }

    public void setCssExpert(boolean cssExpert) {
        isCssExpert = cssExpert;
    }

    public boolean isJavaExpert() {
        return isJavaExpert;
    }

    public void setJavaExpert(boolean javaExpert) {
        isJavaExpert = javaExpert;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }
}
