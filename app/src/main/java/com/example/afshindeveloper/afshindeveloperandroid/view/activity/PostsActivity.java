package com.example.afshindeveloper.afshindeveloperandroid.view.activity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.afshindeveloper.afshindeveloperandroid.ApiService;
import com.example.afshindeveloper.afshindeveloperandroid.DownloadImageTask;
import com.example.afshindeveloper.afshindeveloperandroid.MyAppDatabaseOpenHelper;
import com.example.afshindeveloper.afshindeveloperandroid.R;
import com.example.afshindeveloper.afshindeveloperandroid.adapters.NewsAdapter;
import com.example.afshindeveloper.afshindeveloperandroid.datamodel.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Manifest;

public class PostsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Post> posts=new ArrayList<>();
    private static final int REQUEST_PERMISSION_CODE=200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_news);
        setupRecyclerView();
        getPostsFromDatabase();
        ApiService apiService=new ApiService(this);

        apiService.getposts(new ApiService.OnPostsRecived() {
            @Override
            public void onRecived(List<Post> posts) {
                PostsActivity.this.posts=posts;
                MyAppDatabaseOpenHelper openHelper=new MyAppDatabaseOpenHelper(PostsActivity.this);
               // openHelper.addposts(posts);
                NewsAdapter newsAdapter=new NewsAdapter(PostsActivity.this,posts);
                recyclerView.setAdapter(newsAdapter);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){

                        saveImagesInsdcard();

                    }
                    else
                    {
                        requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_PERMISSION_CODE);
                    }
                }
                else {
                    saveImagesInsdcard();

                }

            }
        });

    }
    private void setupRecyclerView(){
        recyclerView=(RecyclerView)findViewById(R.id.Recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(PostsActivity.this,LinearLayoutManager.VERTICAL,false));

    }
    private  void getPostsFromDatabase(){
        MyAppDatabaseOpenHelper openHelper=new MyAppDatabaseOpenHelper(this);
        List<Post> posts=openHelper.getposts();
        NewsAdapter newsAdapter=new NewsAdapter(this,posts);
        recyclerView.setAdapter(newsAdapter);
    }
    private void saveImagesInsdcard(){
        List<String> urls=new ArrayList<>();
        for (int i=0;i<posts.size();i++){
            urls.add(posts.get(i).getPostimage());
        }
        DownloadImageTask downloadImageTask=new DownloadImageTask(this,urls);
        downloadImageTask.execute();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==REQUEST_PERMISSION_CODE){
            if (grantResults.length>0){
                saveImagesInsdcard();
            }else {
                Toast.makeText(this,"برای ذخیره سازی باید دسترسی لازم را بدهید.",Toast.LENGTH_LONG).show();
            }
        }
    }
}
