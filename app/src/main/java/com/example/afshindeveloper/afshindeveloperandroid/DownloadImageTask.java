package com.example.afshindeveloper.afshindeveloperandroid;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Environment;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by afshindeveloper on 17/09/2017.
 */

public class DownloadImageTask extends AsyncTask<Void,Integer,Void> {
    private Context context;
   private List<String> urls=new ArrayList<>();
    private ProgressDialog progressDialog;
    public DownloadImageTask(Context context, String url){
        urls.add(url);
        this.context = context;
    }
    public DownloadImageTask(Context context,List<String> urls){
        this.urls=urls;
        this.context = context;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog =new ProgressDialog(context);
        progressDialog.setTitle("ذخیره سازی عکس ها");
        progressDialog.setMessage("درحال ذخیره سازی عکس ها, لطفا منتظر بمانید.");
        progressDialog.setIndeterminate(false);
        progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
        progressDialog.show();

    }
    @Override
    protected Void doInBackground(Void... voids) {
        for (int i=0;i<urls.size();i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Bitmap bitmap= Picasso.with(context).load(urls.get(i)).get();
                String url=urls.get(i);


                File extImageDir=context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                String imageName=url.substring(url.lastIndexOf("/")+1,url.length());
                File image=new File(extImageDir,imageName);
                FileOutputStream fos=new FileOutputStream(image);
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,fos);
                fos.flush();
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            publishProgress((i*100/urls.size()));
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.hide();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressDialog.setProgress(values[0]);
    }


}
