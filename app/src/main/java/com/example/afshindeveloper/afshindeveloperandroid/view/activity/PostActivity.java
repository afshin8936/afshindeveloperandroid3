package com.example.afshindeveloper.afshindeveloperandroid.view.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afshindeveloper.afshindeveloperandroid.MyAppDatabaseOpenHelper;
import com.example.afshindeveloper.afshindeveloperandroid.R;
import com.squareup.picasso.Picasso;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Typeface typeface=Typeface.createFromAsset(getAssets(),"fonts/iranian_sans_font.ttf");
        Intent intent=getIntent();
        int id=intent.getIntExtra(MyAppDatabaseOpenHelper.COL_ID,0);
        setPostVisited(id);
        String title=intent.getStringExtra(MyAppDatabaseOpenHelper.COL_TITLE);
        String content=intent.getStringExtra(MyAppDatabaseOpenHelper.COL_CONTENT);
        String image_url=intent.getStringExtra(MyAppDatabaseOpenHelper.COL_POST_IMAGE_URL);
        String date=intent.getStringExtra(MyAppDatabaseOpenHelper.COL_DATE);

        ImageView postimageView=(ImageView)findViewById(R.id.item_image);
        TextView titleTextview=(TextView)findViewById(R.id.new_title);
        TextView contentTextView=(TextView)findViewById(R.id.news_content);
        TextView dataTextView=(TextView)findViewById(R.id.news_date);

        Picasso.with(this).load(image_url).into(postimageView);
        titleTextview.setText(title);
        contentTextView.setText(content);
        dataTextView.setText(date);
        //SET TYPEFACE FONT
        titleTextview.setTypeface(typeface);
        contentTextView.setTypeface(typeface);
        dataTextView.setTypeface(typeface);

    }
    private void setPostVisited(int postId){
        MyAppDatabaseOpenHelper openHelper=new MyAppDatabaseOpenHelper(this);
        openHelper.setpostisvisited(postId,1);

    }
}
