package com.example.afshindeveloper.afshindeveloperandroid.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.afshindeveloper.afshindeveloperandroid.view.fragment.ClothesFragment;

/**
 * Created by afshindeveloper on 30/08/2017.
 */

public class ClothesViewPagreAdapter extends FragmentPagerAdapter {

    public ClothesViewPagreAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ClothesFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "مشاهده شده ها";
            case 1:
                return "جدید ترین ها";
            case 2:
                return "پر بازدید ترین ها";
            case 3:
                return "مردانه";
            case 4:
                return "زنانه";
            default:
                return "okkkkkkk";
        }
    }
}
