package com.example.afshindeveloper.afshindeveloperandroid.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.afshindeveloper.afshindeveloperandroid.DataFakeGenerator1;
import com.example.afshindeveloper.afshindeveloperandroid.R;
import com.example.afshindeveloper.afshindeveloperandroid.adapters.ClothesAdapter;

/**
 * Created by afshindeveloper on 30/08/2017.
 */

public class ClothesFragment extends Fragment {
    private RecyclerView recyclerView;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_clothes,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.clothes_recycler);
        ClothesAdapter clothesAdapter=new ClothesAdapter(getActivity(), DataFakeGenerator1.getClothes(getActivity()));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(clothesAdapter);
        return view;
    }

    public static ClothesFragment newInstance() {

        Bundle args = new Bundle();

        ClothesFragment fragment = new ClothesFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
