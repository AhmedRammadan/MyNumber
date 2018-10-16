package com.example.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class call extends AppCompatActivity {

    private static TextView text;

    private static final int   MY_PERMISSIONS_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        text=findViewById(R.id.text);
        checkPermission();
    }

    public void call(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+text.getText().toString()));
        startActivity(callIntent);

}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    public void one(View view) {
        text.setText(text.getText().toString()+"1");
    }
    public void two(View view) {
        text.setText(text.getText().toString()+"2");
    }
    public void three(View view) {
        text.setText(text.getText().toString()+"3");
    }
    public void four(View view) {
        text.setText(text.getText().toString()+"4");
    }
    public void five(View view) {
        text.setText(text.getText().toString()+"5");
    }
    public void six(View view) {
        text.setText(text.getText().toString()+"6");
    }
    public void seven(View view) {
        text.setText(text.getText().toString()+"7");
    }
    public void eight(View view) {
        text.setText(text.getText().toString()+"8");
    }
    public void nine(View view) {
        text.setText(text.getText().toString()+"9");
    }
    public void zero(View view) {
        text.setText(text.getText().toString()+"0");
    }
    public void window(View view) {
        text.setText(text.getText().toString()+"#");
    }
    public void star(View view) {
        text.setText(text.getText().toString()+"*");
    }

    public void  checkPermission(){
        // Here, thisActivity is the current activity

        if (ContextCompat.checkSelfPermission(call.this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(call.this,Manifest.permission.CALL_PHONE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                ActivityCompat.requestPermissions(call.this,new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST);
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(call.this,new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            return;
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0&& grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                   return;
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    checkPermission();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }}