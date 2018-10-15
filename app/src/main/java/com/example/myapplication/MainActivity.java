package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.myapplication.adapter.PagerAdapter;

public class MainActivity extends AppCompatActivity {

    int tabIcons[]={R.drawable.ic_star,R.drawable.ic_emergency};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,call.class));

            }
        });
        PagerAdapter adapter =new PagerAdapter(getSupportFragmentManager());
        ViewPager viewPager =findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout =findViewById(R.id.tabLayout);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        new Intent(Intent.ACTION_CALL, Uri.parse("01066727482"));
    }
}

