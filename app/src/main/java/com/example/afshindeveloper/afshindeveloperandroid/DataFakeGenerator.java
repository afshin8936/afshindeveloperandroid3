package com.example.afshindeveloper.afshindeveloperandroid;

import android.content.Context;

import com.example.afshindeveloper.afshindeveloperandroid.view.activity.AnimationsMainActivity;
import com.example.afshindeveloper.afshindeveloperandroid.view.activity.BotickActivity;
import com.example.afshindeveloper.afshindeveloperandroid.view.activity.WeatherSampleActivity;
import com.example.afshindeveloper.afshindeveloperandroid.view.activity.PostsActivity;
import com.example.afshindeveloper.afshindeveloperandroid.view.activity.MainActivity;
import com.example.afshindeveloper.afshindeveloperandroid.view.activity.PostActivity;
import com.example.afshindeveloper.afshindeveloperandroid.view.activity.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saeed shahini on 7/21/2016.
 */
public class DataFakeGenerator {
    public static List<AppFeature> getAppFeatures(Context context){
        List<AppFeature> appFeatures=new ArrayList<>();
        AppFeature appFeature=new AppFeature();
        appFeature.setId(AppFeature.ID_POSTS_ACTIVITY);
        appFeature.setTitle(context.getString(R.string.app_feature_latest_posts));
        appFeature.setFeatureImage(R.drawable.posts);
       appFeature.setDestinationActivity(PostsActivity.class);
        appFeatures.add(appFeature);
        appFeature=new AppFeature();
        appFeature.setId(AppFeature.ID_USER_PROFILE);
        appFeature.setTitle(context.getString(R.string.app_feature_user_profile));
        appFeature.setFeatureImage(R.drawable.user_profile);
        appFeature.setDestinationActivity(Profile.class);
        appFeatures.add(appFeature);

        appFeature=new AppFeature();
        appFeature.setId(AppFeature.ID_FASHION);
        appFeature.setTitle(context.getString(R.string.app_feature_fashion));
        appFeature.setFeatureImage(R.drawable.fashion);
      appFeature.setDestinationActivity(BotickActivity.class);
        appFeatures.add(appFeature);

        appFeature=new AppFeature();
        appFeature.setId(AppFeature.ID_MUSIC);
        appFeature.setTitle(context.getString(R.string.app_feature_music_player));
        appFeature.setFeatureImage(R.drawable.music_player);
        appFeature.setDestinationActivity(MainActivity.class);
        appFeatures.add(appFeature);

        appFeature=new AppFeature();
        appFeature.setId(AppFeature.ID_VIDEO);
        appFeature.setTitle(context.getString(R.string.app_feature_video_player));
        appFeature.setFeatureImage(R.drawable.video_player);
        appFeature.setDestinationActivity(WeatherSampleActivity.class);
        appFeatures.add(appFeature);

        appFeature=new AppFeature();
        appFeature.setId(AppFeature.ID_LOGIN);
        appFeature.setTitle(context.getString(R.string.app_feature_login));
        appFeature.setFeatureImage(R.drawable.login);
        appFeature.setDestinationActivity(PostActivity.class);
        appFeatures.add(appFeature);

appFeature=new AppFeature();
        appFeature.setId(AppFeature.ID_ANIMATIONS);
        appFeature.setTitle(context.getString(R.string.animations_main_activity_toolbar_title));
        appFeature.setFeatureImage(R.drawable.animations_in_android);
        appFeature.setDestinationActivity(AnimationsMainActivity.class);
        appFeatures.add(appFeature);
        return appFeatures;
    }
}
