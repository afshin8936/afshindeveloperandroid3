package com.example.afshindeveloper.afshindeveloperandroid;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.EventLogTags;
import android.util.Log;

import com.example.afshindeveloper.afshindeveloperandroid.datamodel.Post;

import java.util.List;

/**
 * Created by afshindeveloper on 16/09/2017.
 */

public class AddPostsTask extends AsyncTask<Void,Integer,String> {
    private static final String TAG = "AddPostsTask";
    private Context context;
    private List<Post> posts;
    private MyAppDatabaseOpenHelper myAppDatabaseOpenHelper;
    private ProgressDialog progressDialog;

    public AddPostsTask(Context context, List<Post>posts,MyAppDatabaseOpenHelper openHelper){
        this.context = context;
        this.posts = posts;
        this.myAppDatabaseOpenHelper=openHelper;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("در حال ذخیره سازی");
        progressDialog.setMessage("در حال ذخیره ساز‍ی پست ها لطفا منتظر بمانید... ");
        progressDialog.setIndeterminate(false);
        progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(Void... paramses) {
        for (int i=0;i<posts.size(); i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ContentValues cv=new ContentValues();
            Post post=posts.get(i);
            cv.put(MyAppDatabaseOpenHelper.COL_ID,post.getId());
            cv.put(MyAppDatabaseOpenHelper.COL_TITLE,post.getTitle());
            cv.put(MyAppDatabaseOpenHelper.COL_CONTENT,post.getContent());
            cv.put(MyAppDatabaseOpenHelper.COL_POST_IMAGE_URL,post.getPostimage());
            cv.put(MyAppDatabaseOpenHelper.COL_IS_VISITED,post.getIsvisited());
            cv.put(MyAppDatabaseOpenHelper.COL_DATE,post.getDate());
            SQLiteDatabase sqLiteDatabase=myAppDatabaseOpenHelper.getWritableDatabase();
            long isInserted=sqLiteDatabase.insert(MyAppDatabaseOpenHelper.POST_TABLE_NAME,null,cv);
            publishProgress((i*100)/posts.size());

            Log.i(TAG, "addpost: "+isInserted);
        }
        return "";
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.hide();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressDialog.setProgress(values[0]);
    }
}
