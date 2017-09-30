package com.example.afshindeveloper.afshindeveloperandroid.view.activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.afshindeveloper.afshindeveloperandroid.MyApplication;
import com.example.afshindeveloper.afshindeveloperandroid.R;

public class AnimationsMainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations_main);
        setupToolbar();
        setupButtons();
    }

    private void setupToolbar() {
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        for (int i = 0; i < toolbar.getChildCount(); i++) {
            if (toolbar.getChildAt(i) instanceof TextView){
                ((TextView) toolbar.getChildAt(i)).setTypeface(MyApplication.getiraniansansfont());
            }
        }
    }
    private void setupButtons(){
        Button alphaAnimationButton=(Button)findViewById(R.id.button_alpha_animation);
        alphaAnimationButton.setOnClickListener(this);

        Button translateAnimationButton=(Button)findViewById(R.id.button_translate_animation);
        translateAnimationButton.setOnClickListener(this);

        Button scaleAnimationButton=(Button)findViewById(R.id.button_scale_animation);
        scaleAnimationButton.setOnClickListener(this);

        Button rotateAnimationButton=(Button)findViewById(R.id.button_rotate_animation);
        rotateAnimationButton.setOnClickListener(this);

        Button valueAnimatorAnimationButton=(Button)findViewById(R.id.button_value_animator);
        valueAnimatorAnimationButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(this,AnimationActivity.class);
        intent.putExtra(AnimationActivity.EXTRA_KEY_ANIMATION_TYPE,
        Integer.parseInt((String) view.getTag()));
        startActivity(intent);
    }
}
