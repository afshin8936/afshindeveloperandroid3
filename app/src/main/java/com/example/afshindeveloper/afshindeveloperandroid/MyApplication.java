package com.example.afshindeveloper.afshindeveloperandroid;

import android.app.Application;
import android.graphics.Typeface;

/**
 * Created by afshindeveloper on 24/09/2017.
 */

public class MyApplication extends Application {
    private static Typeface iraniansansfont;
    @Override
    public void onCreate() {
        super.onCreate();
        iraniansansfont=Typeface.createFromAsset(getAssets(),"fonts/iranian_sans_font.ttf");
    }
    public static Typeface getiraniansansfont(){
        return iraniansansfont;
    }


}
