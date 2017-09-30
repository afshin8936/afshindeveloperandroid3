package com.example.afshindeveloper.afshindeveloperandroid.view.activity;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.afshindeveloper.afshindeveloperandroid.R;
import com.example.afshindeveloper.afshindeveloperandroid.UserSharedPrefManager;
import com.example.afshindeveloper.afshindeveloperandroid.datamodel.User;

public class Profile extends AppCompatActivity {
   private User user=new User();
    private UserSharedPrefManager prefManager;
    private Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        prefManager=new UserSharedPrefManager(this);
        user=prefManager.getuser();

        Button btneditavatar = (Button) findViewById(R.id.edit_avatar);
        btneditavatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Profile.this, "ویرایش عکس کلیک شد", Toast.LENGTH_LONG).show();
            }
        });
         typeface = Typeface.createFromAsset(getAssets(), "fonts/iranian_sans_font.ttf");
        EditText firstNameEditText = (EditText) findViewById(R.id.edittext_frist_name);
        firstNameEditText.setTypeface(typeface);
        firstNameEditText.setText(user.getFirst_name());
        EditText lastnameedittext = (EditText) findViewById(R.id.edittext_last_name);
        lastnameedittext.setTypeface(typeface);
        lastnameedittext.setText(user.getLast_name());
        firstNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Toast.makeText(Profile.this,charSequence.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               // Toast.makeText(Profile.this,charSequence.toString(),Toast.LENGTH_LONG).show();
                user.setFirst_name(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {
               //Toast.makeText(Profile.this,editable.toString(),Toast.LENGTH_LONG).show();

            }
        });
        lastnameedittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
             user.setLast_name(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        final CheckBox javacheckbox=(CheckBox)findViewById(R.id.checkbox_java);
        final CheckBox csscheckbox=(CheckBox)findViewById(R.id.checkbox_css);
        final CheckBox htmlcheckbox=(CheckBox)findViewById(R.id.checkbox_html);
        javacheckbox.setChecked(user.isJavaExpert());
        csscheckbox.setChecked(user.isCssExpert());
        htmlcheckbox.setChecked(user.isHtmlExpert());
        javacheckbox.setTypeface(typeface);
        csscheckbox.setTypeface(typeface);
        htmlcheckbox.setTypeface(typeface);
        javacheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (javacheckbox.isChecked()){
                    Toast.makeText(Profile.this,"جاوا انتخاب شد.",Toast.LENGTH_LONG).show();
                    user.setJavaExpert(b);

                }
                else {
                    Toast.makeText(Profile.this,"جاوا برداشته شد.",Toast.LENGTH_LONG).show();

                }
            }
        });
        csscheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (csscheckbox.isChecked()){
                    Toast.makeText(Profile.this,"  انتخاب شد. css ",Toast.LENGTH_LONG).show();
                    user.setCssExpert(b);

                }
                else {
                    Toast.makeText(Profile.this," css .برداشته  شد",Toast.LENGTH_LONG).show();

                }
            }
        });
        htmlcheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (htmlcheckbox.isChecked()){
                    Toast.makeText(Profile.this,"HTML انتخاب شد.",Toast.LENGTH_LONG).show();
                    user.setHtmlExpert(b);

                }
                else {
                    Toast.makeText(Profile.this,"HTML برداشته شد.",Toast.LENGTH_LONG).show();

                }
            }
        });
        final RadioButton radiomale=(RadioButton)findViewById(R.id.radio_male);
        RadioButton radiofemale=(RadioButton)findViewById(R.id.radio_female);
        radiofemale.setTypeface(typeface);
        radiomale.setTypeface(typeface);
        byte gender=user.getGender();
        if(gender==user.male){
            radiomale.setChecked(true);
        }
        else {
            radiofemale.setChecked(true);
        }
        radiomale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (radiomale.isChecked()){
                    Toast.makeText(Profile.this,"مرد",Toast.LENGTH_LONG).show();
                    user.setGender(user.male);

                }
                else {
                    Toast.makeText(Profile.this,"زن",Toast.LENGTH_LONG).show();
                    user.setGender(user.female);
                }
            }
        });
      Button btnsave=(Button)findViewById(R.id.btn_save);
        btnsave.setTypeface(typeface);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             prefManager.saveuser(user);
                Toast.makeText(Profile.this,"دکمه سیو کلیک شد.",Toast.LENGTH_LONG).show();
            }
        });
        setuptoolbar();
    }
    private void setuptoolbar(){
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
        for (int i=0;i<toolbar.getChildCount();i++){
            if (toolbar.getChildAt(i) instanceof TextView){
                ((TextView) toolbar.getChildAt(i)).setTypeface(typeface);
            }
        }
    }
}
