package com.example.afshindeveloper.afshindeveloperandroid;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.afshindeveloper.afshindeveloperandroid.datamodel.User;

/**
 * Created by afshindeveloper on 10/09/2017.
 */

public class UserSharedPrefManager {

    private static final String USER_SHARED_PREF_NAME = "user_shared_pref";
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";
    private static final String KEY_HTML_EXPERT = "is_html_expert";
    private static final String KEY_CSS_EXPERT = "is_css_expert";
    private static final String KEY_JAVA_EXPERT = "is_java_expert";
    private static final String KEY_GENDER = "genedr";

    private SharedPreferences sharedPreferences;

    public UserSharedPrefManager(Context context) {

        sharedPreferences = context.getSharedPreferences(USER_SHARED_PREF_NAME, context.MODE_PRIVATE);

    }

    public void saveuser(User user) {
        if (user != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_FIRST_NAME, user.getFirst_name());
            editor.putString(KEY_LAST_NAME, user.getLast_name());
            editor.putBoolean(KEY_HTML_EXPERT, user.isHtmlExpert());
            editor.putBoolean(KEY_CSS_EXPERT, user.isCssExpert());
            editor.putBoolean(KEY_JAVA_EXPERT, user.isJavaExpert());
            editor.putInt(KEY_GENDER, user.getGender());
            editor.apply();
        }
    }

    public User getuser() {
        User user = new User();
        user.setFirst_name(sharedPreferences.getString(KEY_FIRST_NAME, ""));
        user.setLast_name(sharedPreferences.getString(KEY_LAST_NAME, ""));
        user.setHtmlExpert(sharedPreferences.getBoolean(KEY_HTML_EXPERT, false));
        user.setCssExpert(sharedPreferences.getBoolean(KEY_CSS_EXPERT, false));
        user.setJavaExpert(sharedPreferences.getBoolean(KEY_JAVA_EXPERT, false));
        user.setGender((byte) sharedPreferences.getInt(KEY_GENDER, user.male));
        return user;
    }
}
