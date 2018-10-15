package com.example.myapplication.Fragment;


import android.Manifest;
import android.app.Activity;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_1 extends Fragment {

   private static final int   MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
   private String uri= "05616561";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view =inflater.inflate(R.layout.fragment_fragment_1, container, false);
        final ArrayList<Items> items = new ArrayList<>();
        items.add(new Items(R.drawable.my_pro,"01115458654","my pro"));
        items.add(new Items(R.drawable.osama_abuzid,"0100545865", "Osama Abuzid"));
        items.add(new Items(R.drawable.gamal_abomera,"0125458654", "Gamal Abomera"));
        items.add(new Items(R.drawable.hassan_ahmed,"0112151551","Hassan Ahmed"));
        items.add(new Items(R.drawable.mohamed,"0125451661","mohamed"));
        items.add(new Items(R.drawable.my_pro,"01115458654","my pro"));
        items.add(new Items(R.drawable.osama_abuzid,"0100545865", "Osama Abuzid"));
        items.add(new Items(R.drawable.gamal_abomera,"0125458654", "Gamal Abomera"));
        items.add(new Items(R.drawable.hassan_ahmed,"0112151551","Hassan Ahmed"));
        items.add(new Items(R.drawable.mohamed,"0125451661","mohamed"));
        ListView list =view.findViewById(R.id.list_f1);
        ItemAdapter adapter =new ItemAdapter(getContext(),0,items);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Items item=items.get(position);
               uri = item.getNumber();
               checkPermission();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+uri));
                startActivity(callIntent);
            }
        });
        return view;
    }
    public void  checkPermission(){
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
           return;
        }
        else{
            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) getContext(),Manifest.permission.CALL_PHONE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                Toast.makeText(getContext(), "done", Toast.LENGTH_SHORT).show();
                return;
            }  // No explanation needed; request the permission
            int MY_PERMISSIONS_REQUEST_READ_CONTACTS =1;
            ActivityCompat.requestPermissions((Activity) getContext(),new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);

            // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
            // app-defined int constant. The callback method gets the
            // result of the request.
            return;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }
}
