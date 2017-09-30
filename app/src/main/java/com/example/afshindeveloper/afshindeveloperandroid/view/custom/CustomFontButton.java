package com.example.afshindeveloper.afshindeveloperandroid.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.example.afshindeveloper.afshindeveloperandroid.MyApplication;

/**
 * Created by afshindeveloper on 24/09/2017.
 */

public class CustomFontButton extends Button {
    public CustomFontButton(Context context) {
        super(context);
        if (!isInEditMode()){
            setupButton();
        }
    }

    public CustomFontButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()){
            setupButton();
        }
    }

    public CustomFontButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()){
            setupButton();
        }
    }

    public CustomFontButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if (!isInEditMode()){
            setupButton();
        }
    }
    private void setupButton(){
        MyApplication myApplication=(MyApplication)getContext().getApplicationContext();
        setTypeface(myApplication.getiraniansansfont());
    }
}
