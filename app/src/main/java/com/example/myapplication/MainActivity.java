package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.adapter.PagerAdapter;


public class MainActivity extends AppCompatActivity {


    int tabIcons[]={R.drawable.ic_star,R.drawable.ic_emergency};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PagerAdapter adapter =new PagerAdapter(getSupportFragmentManager());
        ViewPager viewPager =findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout =findViewById(R.id.tabLayout);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        new Intent(Intent.ACTION_CALL, Uri.parse("01066727482"));
    }
    public void  checkPermission(View v){
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            Intent callIntent =new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:6038994210"));
            startActivity(callIntent);
        }
        else{
            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.CALL_PHONE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                Toast.makeText(MainActivity.this, "done", Toast.LENGTH_SHORT).show();
            }  // No explanation needed; request the permission
            int MY_PERMISSIONS_REQUEST_READ_CONTACTS =1;
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);

            // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
            // app-defined int constant. The callback method gets the
            // result of the request.
        }
    }

}
