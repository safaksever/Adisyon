package com.example.safak.adisyon;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends ArrayAdapter<ParentProvider>{
    private List<ParentProvider> list ;

    public MyListAdapter(@NonNull Context context, List<ParentProvider> list){
        super(context,R.layout.row_layout,list);
        this.list = list;
    }

    static class LayoutHandler{
        ImageView foto;
        TextView ad,fiyat;
    }

    @Override
    public void add(ParentProvider dataProvider) {
        super.add(dataProvider);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        LayoutHandler layoutHandler;
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.foto = (ImageView) view.findViewById(R.id.fotoDT);
            layoutHandler.ad = (TextView) view.findViewById(R.id.textDT);
            layoutHandler.fiyat = (TextView) view.findViewById(R.id.textfiyatDT);
            view.setTag(layoutHandler);
        }
        else
            layoutHandler = (LayoutHandler) view.getTag();
        ParentProvider provider = list.get(position);
        layoutHandler.foto.setImageResource(provider.getFoto());
        layoutHandler.ad.setText(provider.getAd());
        layoutHandler.fiyat.setText(String.valueOf(provider.getFiyat()));
        return view;
    }
}
