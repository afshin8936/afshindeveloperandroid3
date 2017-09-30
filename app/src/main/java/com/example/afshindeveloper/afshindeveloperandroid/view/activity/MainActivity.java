package com.example.afshindeveloper.afshindeveloperandroid.view.activity;

import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.afshindeveloper.afshindeveloperandroid.AppFeaturesAdapter;
import com.example.afshindeveloper.afshindeveloperandroid.DataFakeGenerator;
import com.example.afshindeveloper.afshindeveloperandroid.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity";
    private AppFeaturesAdapter appFeaturesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }
    private void setupViews()
    {
        setupToolbar();
        setupRecyclerView();
        setupNavigationView();
        final CoordinatorLayout coordinatorLayout=(CoordinatorLayout)findViewById(R.id.coordinator_layout);
        FloatingActionButton Button=(FloatingActionButton)findViewById(R.id.float_action_button);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(coordinatorLayout,"Float Action Button Clicked!!!",Snackbar.LENGTH_LONG).
                        setAction("RETRY", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this,"Retry Button Clicked",Toast.LENGTH_LONG).show();
                            }
                        }).show();

            }
        });
    }

    private void setupNavigationView() {
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_menu_profile:
                        startActivity(new Intent(MainActivity.this,Profile.class));
                        break;
                    case R.id.navigation_menu_store:
                        startActivity(new Intent(MainActivity.this,BotickActivity.class));
                        break;
                    case R.id.shotdown:
                        finish();
                        break;
                }
                return true;
            }
        });
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position==0){
                    return 2;
                }
                else {
                    return 1;

                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        appFeaturesAdapter=new AppFeaturesAdapter(this);
        recyclerView.setAdapter(appFeaturesAdapter);
        appFeaturesAdapter.setAppFeatures(DataFakeGenerator.getAppFeatures(this));

    }
    private void setupToolbar(){
        DrawerLayout drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.white));
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

    }
}
