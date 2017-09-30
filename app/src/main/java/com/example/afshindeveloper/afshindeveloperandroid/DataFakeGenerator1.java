package com.example.afshindeveloper.afshindeveloperandroid;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;

import com.example.afshindeveloper.afshindeveloperandroid.datamodel.Clothe;
import com.example.afshindeveloper.afshindeveloperandroid.datamodel.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by afshindeveloper on 22/08/2017.
 */

public class DataFakeGenerator1 {
    public static List<Post> getdata(Context context){
      /*
        List<Post> posts=new ArrayList<>();
        for (int i=1;i<=6;i++){
            Post post=new Post();
            post.setId(i);
            post.setTitle("پست"+i);
            post.setContent("متن پست"+i+"سلام بنده افشین داداش نژاد هستم");
            post.setDate("دو ساعت پیش");
            switch (i){
                case 1:
                    post.setPostimage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic1,null));
                    break;
                case 2:
                    post.setPostimage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic2,null));
                    break;
                case 3:
                    post.setPostimage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic3,null));
                    break;
                case 4:
                    post.setPostimage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic4,null));
                    break;
                case 5:
                    post.setPostimage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic5,null));
                    break;
                case 6:
                    post.setPostimage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic6,null));
                    break;

            }
            posts.add(post);
            }
        */


        return null;
    }

    public static List<Clothe> getClothes(Context context){

        List<Clothe> clothes=new ArrayList<>();
        for (int i=1;i<=8;i++){
            Clothe clothe=new Clothe();
            clothe.setId(i);
            clothe.setTitle("افشین داداش نژاد");
            clothe.setViewcount(700);
            switch (i){
                case 1:
                    clothe.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic1_clothes,null));
                    break;
                case 2:
                    clothe.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic2__clothes,null));
                    break;
                case 3:
                    clothe.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic3_clothes,null));
                    break;
                case 4:
                    clothe.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic4_clothes,null));
                    break;
                case 5:
                    clothe.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic5_clothes,null));
                    break;
                case 6:
                    clothe.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic6_clothes,null));
                    break;
                case 7:
                    clothe.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic7_clothes,null));
                    break;
                case 8:
                    clothe.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic8_clothes,null));
                    break;

            }
            clothes.add(clothe);
        }
        return clothes;
    }
}
