package com.example.myapplication.Fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Items;
import com.example.myapplication.R;
import com.example.myapplication.adapter.ItemAdapter;

import java.util.ArrayList;


public class Fragment_2 extends Fragment {

    private static final int   MY_PERMISSIONS_REQUEST =1;
    private String uri="05616561";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_fragment_2, container, false);
        final ArrayList<Items> items=new ArrayList<>();
        items.add(new Items(R.drawable.policeman,"122","police"));
        items.add(new Items(R.drawable.firefighter,"180", "Firefighter"));
        items.add(new Items(R.drawable.ambulance,"123","Ambulance"));
        ListView list =view.findViewById(R.id.list_f2);
        ItemAdapter adapter =new ItemAdapter(getContext(),0,items);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Items item=items.get(position);
                uri = item.getNumber();
                checkPermission();
                if (ContextCompat.checkSelfPermission(getContext(),Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED) {
                    call(uri);
                }
            }
        });
        return view;
    }
    public void  checkPermission(){
        try {
            // Here, thisActivity is the current activity

        if (ContextCompat.checkSelfPermission(getContext(),Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) getContext(),Manifest.permission.CALL_PHONE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                ActivityCompat.requestPermissions((Activity) getContext(),new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST);
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions((Activity) getContext(),new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            return;
        }
        }catch (Exception e){
            Toast.makeText(getContext(), "1", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        try {switch (requestCode) {
            case MY_PERMISSIONS_REQUEST: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0&& grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    call(uri);
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    checkPermission();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }}catch (Exception e){
        Toast.makeText(getContext(), "2", Toast.LENGTH_SHORT).show();
    }
    }
    public  void call(String muri){
       try {
           Intent callIntent = new Intent(Intent.ACTION_CALL);

        callIntent.setData(Uri.parse("tel:"+muri));
        startActivity(callIntent);
    }catch (Exception e) {
           Toast.makeText(getContext(), "5", Toast.LENGTH_SHORT).show();
    }
    }
}
