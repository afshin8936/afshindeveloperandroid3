package com.example.afshindeveloper.afshindeveloperandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.afshindeveloper.afshindeveloperandroid.datamodel.Post;

import java.util.ArrayList;
import java.util.List;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by afshindeveloper on 12/09/2017.
 */

public class MyAppDatabaseOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseOpenHelper";
    private static final String DATABASE_NAME="db_7learn";
    private static final int DATABASE_VERSION=1;
    public static final String POST_TABLE_NAME="tbl_posts";
    public static final String COL_ID = "col_id";
    public static final String COL_TITLE = "col_title";
    public static final String COL_CONTENT = "col_content";
    public static final String COL_POST_IMAGE_URL = "col_post_image_url";
    public static final String COL_IS_VISITED = "col_is_visited";
    public static final String COL_DATE = "col_date";
    private static final String SQL_COMMAND_CREATE_POST_TABLE = "CREATE TABLE IF NOT EXISTS " +POST_TABLE_NAME+"(" +
            COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COL_TITLE+" TEXT, "+
            COL_CONTENT+" TEXT, "+
            COL_POST_IMAGE_URL+" TEXT, "+
            COL_IS_VISITED+" INTEGER DEFAULT 0, "+
            COL_DATE+" TEXT);";
    Context context;

    public MyAppDatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try {
            sqLiteDatabase.execSQL(SQL_COMMAND_CREATE_POST_TABLE);

        }
        catch (SQLException e){
            Log.e(TAG,"onCreate: "+e.toString());
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addposts(List<Post> posts){

        AddPostsTask addPostsTask=new AddPostsTask(context,posts,this);
        addPostsTask.execute();
    }
    public List<Post> getposts(){
        List<Post> posts=new ArrayList<>();

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+POST_TABLE_NAME,null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            while (!cursor.isAfterLast()){
             Post post=new Post();
                post.setId(cursor.getInt(0));
                post.setTitle(cursor.getString(1));
                post.setContent(cursor.getString(2));
                post.setPostimage(cursor.getString(3));
                post.setIsvisited(cursor.getInt(4));
                post.setDate(cursor.getString(5));
                posts.add(post);
                cursor.moveToNext();
            }
        }
        cursor.close();
        sqLiteDatabase.close();
        return posts;
    }
    public void setpostisvisited(int postId,int isvisited){
     SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_IS_VISITED,isvisited);
        int rowAffected=sqLiteDatabase.update(POST_TABLE_NAME,contentValues,COL_ID+" = ?",new String[]{String.valueOf(postId)});
        Log.i(TAG, "setpostisvisited: rowaffected=> "+rowAffected);
        sqLiteDatabase.close();

    }
    private boolean checkPostExists(int postId){
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
       Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM "
               +POST_TABLE_NAME+" WHERE "
                +COL_ID+
                " = ?",new String[]{String.valueOf(postId)});
        return cursor.moveToFirst();
    }
    private void deletPost(int postId){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.delete(POST_TABLE_NAME,COL_ID+" = ?",new String[]{String.valueOf(postId)} );
    }
}
