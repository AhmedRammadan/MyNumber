package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Items;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Items> {
    public ItemAdapter(Context context, int resource, ArrayList<Items> items) {
        super(context, 0, items);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItmeView=convertView;
        if (listItmeView==null){
            listItmeView= LayoutInflater.from(getContext()).inflate(R.layout.item,parent,false);
        }
        Items itemsMyFavourite =getItem(position);
        ImageView image=listItmeView.findViewById(R.id.image);
        image.setImageResource(itemsMyFavourite.getImage());
        TextView name=listItmeView.findViewById(R.id.nameNumber);
        name.setText(itemsMyFavourite.getName());
        TextView number=listItmeView.findViewById(R.id.number);
        number.setText(itemsMyFavourite.getNumber());
        return listItmeView;
    }
}
