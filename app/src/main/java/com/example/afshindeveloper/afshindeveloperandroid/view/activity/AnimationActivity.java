package com.example.afshindeveloper.afshindeveloperandroid.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.example.afshindeveloper.afshindeveloperandroid.R;
public class AnimationActivity extends AppCompatActivity {
    private static final String TAG = "AnimationActivity";
    public static final String EXTRA_KEY_ANIMATION_TYPE="animation_type";
    private int animationType=0;
    public static final int TYPE_ALPHA =0;
    public static final int TYPE_TRANSLATE=1;
    public static final int TYPE_SCALE=2;
    public static final int TYPE_ROTATE=3;
    public static final int TYPE_VALUE_ANIMATOR=4;

    private ImageView kouroshImage;
    private SwitchCompat loadFromXmlSwitch;
    private boolean mustLoadFromXml=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        animationType=getIntent().getIntExtra(EXTRA_KEY_ANIMATION_TYPE, TYPE_ALPHA);
        Log.i(TAG, "Animation Type Selected: "+animationType);
        Button startButton=(Button)findViewById(R.id.button_start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAnimation();
            }
        });

        kouroshImage=(ImageView)findViewById(R.id.image_kourosh);
        loadFromXmlSwitch=(SwitchCompat)findViewById(R.id.switch_load_from_xml);
        loadFromXmlSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mustLoadFromXml=b;
            }
        });
    }

    private void showAnimation() {
        switch (animationType){
            case TYPE_ALPHA:
                showAlphaAnimation();
                break;
            case TYPE_TRANSLATE:
                showTranslateAnimation();
                break;
            case TYPE_SCALE:
                showScaleAnimation();
                break;
            case TYPE_ROTATE:
                showRotateAnimation();
                break;
            case TYPE_VALUE_ANIMATOR:
                break;
        }
    }

    private void showAlphaAnimation(){
        if (mustLoadFromXml){
            AlphaAnimation alphaAnimation= (AlphaAnimation) AnimationUtils.loadAnimation(this,R.anim.sample_alpha);
            alphaAnimation.setDuration(2000);
            alphaAnimation.setRepeatCount(Animation.INFINITE);
            alphaAnimation.setRepeatMode(Animation.REVERSE);
            kouroshImage.startAnimation(alphaAnimation);
        }else {
            AlphaAnimation alphaAnimation=new AlphaAnimation(1.0f,0.5f);
            alphaAnimation.setDuration(2000);
            alphaAnimation.setFillAfter(true);
            kouroshImage.startAnimation(alphaAnimation);
        }
    }

    private void showTranslateAnimation(){
        if (mustLoadFromXml){
            TranslateAnimation translateAnimation= (TranslateAnimation) AnimationUtils.loadAnimation(this,R.anim.sample_translate);
            translateAnimation.setDuration(1000);
            translateAnimation.setRepeatCount(Animation.INFINITE);
            translateAnimation.setRepeatMode(Animation.REVERSE);
            translateAnimation.setInterpolator(new AccelerateInterpolator());
            kouroshImage.startAnimation(translateAnimation);
        }else {
            TranslateAnimation translateAnimation=new TranslateAnimation(
                    Animation.ABSOLUTE,0,Animation.ABSOLUTE,200,Animation.ABSOLUTE,0,Animation.RELATIVE_TO_PARENT,1.0f);
            translateAnimation.setDuration(2000);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new BounceInterpolator());
            kouroshImage.startAnimation(translateAnimation);
        }
    }

    private void showScaleAnimation(){
        if (mustLoadFromXml){
            ScaleAnimation scaleAnimation= (ScaleAnimation) AnimationUtils.loadAnimation(this,R.anim.sample_scale);
            scaleAnimation.setDuration(1000);
            scaleAnimation.setRepeatCount(Animation.INFINITE);
            scaleAnimation.setRepeatMode(Animation.REVERSE);
            scaleAnimation.setInterpolator(new DecelerateInterpolator());
            kouroshImage.startAnimation(scaleAnimation);

        }else {
            ScaleAnimation scaleAnimation=new ScaleAnimation(1.0f,2.0f,1.0f,2.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setInterpolator(new AccelerateInterpolator());
            scaleAnimation.setDuration(1000);
            kouroshImage.startAnimation(scaleAnimation);
        }

    }
   private void showRotateAnimation(){
       RotateAnimation rotateAnimation=new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
       rotateAnimation.setDuration(2000);
       rotateAnimation.setFillAfter(true);
       rotateAnimation.setRepeatCount(0);
       kouroshImage.startAnimation(rotateAnimation);
   }



}
