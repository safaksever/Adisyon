package com.example.safak.adisyon.listele;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.safak.adisyon.MyListAdapter;
import com.example.safak.adisyon.ParentProvider;
import com.example.safak.adisyon.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Listele5 extends Activity {

    ListView listView;
    MyListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listele5);

        final SharedPreferences sharedPreferences = getSharedPreferences("urun5", Context.MODE_PRIVATE);
        String jsonurun = sharedPreferences.getString("liste5", "");
        Gson gson = new Gson();
        final ParentProvider[] providers = gson.fromJson(jsonurun, ParentProvider[].class);
        final List<ParentProvider> list = new ArrayList<>(Arrays.asList(providers));
        listAdapter = new MyListAdapter(getApplicationContext(), list);
        listView = (ListView) findViewById(R.id.liste5);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final ParentProvider dataProvider = (ParentProvider) adapterView.getItemAtPosition(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(Listele5.this);
                builder.setMessage("Silinsin mi ?")
                        .setCancelable(false)
                        .setPositiveButton("EVET", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                list.remove(dataProvider);
                                listAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("SİPARİŞ SİL");
                alert.show();
            }
        });
    }
}
