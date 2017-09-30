package com.example.afshindeveloper.afshindeveloperandroid.view.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.afshindeveloper.afshindeveloperandroid.MyApplication;
import com.example.afshindeveloper.afshindeveloperandroid.view.activity.MainActivity;

/**
 * Created by afshindeveloper on 24/09/2017.
 */

public class CustomFontTextView  extends android.support.v7.widget.AppCompatTextView{
    public CustomFontTextView(Context context) {
        super(context);
        if (!isInEditMode()){
        setuptextview();
    }

    }

    public CustomFontTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()){
            setuptextview();
        }
    }

    public CustomFontTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()){
            setuptextview();
        }
    }
    public CustomFontTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context);
        if (!isInEditMode()){
            setuptextview();
        }
    }

    private void setuptextview(){
        MyApplication myApplication=(MyApplication)getContext().getApplicationContext();
       setTypeface(myApplication.getiraniansansfont());
    }
}
