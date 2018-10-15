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

    }

}
