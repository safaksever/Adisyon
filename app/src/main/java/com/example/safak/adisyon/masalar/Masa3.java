package com.example.safak.adisyon.masalar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.safak.adisyon.MyExpandableListAdapter;
import com.example.safak.adisyon.MyListAdapter;
import com.example.safak.adisyon.ParentProvider;
import com.example.safak.adisyon.R;
import com.example.safak.adisyon.listele.Listele3;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Masa3 extends Activity {

    ExpandableListView listYemek;
    ListView listDrink, listTatli;
    ParentProvider parentProvider, provider;
    MyExpandableListAdapter myExpandableListAdapter;
    List<ParentProvider> header, list, liste, listi;
    HashMap<ParentProvider, List<ParentProvider>> child;
    MyListAdapter myListAdapter, mListAdapter;
    int i, a, b, c, d, e, f, g, h, x, r = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masa3);

        list = new ArrayList<>();
        liste = new ArrayList<>();
        listi = new ArrayList<>();
        listYemek = (ExpandableListView) findViewById(R.id.listYemek3);
        listDrink = (ListView) findViewById(R.id.listDrink3);
        listTatli = (ListView) findViewById(R.id.listTatli3);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabYemek = tabHost.newTabSpec("Yemekler");
        tabYemek.setContent(R.id.tabYemek);
        tabYemek.setIndicator("YEMEKLER");
        tabHost.addTab(tabYemek);

        TabHost.TabSpec tabIcecekler = tabHost.newTabSpec("Icecekler");
        tabIcecekler.setContent(R.id.tabIcecek);
        tabIcecekler.setIndicator("İÇECEKLER");
        tabHost.addTab(tabIcecekler);

        TabHost.TabSpec tabTatli = tabHost.newTabSpec("Tatlilar");
        tabTatli.setContent(R.id.tabTatli);
        tabTatli.setIndicator("TATLILAR");
        tabHost.addTab(tabTatli);

        String[] titles = getResources().getStringArray(R.array.titles);
        int[] fotos = {R.mipmap.iskender, R.mipmap.tombik, R.mipmap.yarim, R.mipmap.durum, R.mipmap.porsiyon,
                R.mipmap.pilav, R.mipmap.salata, R.mipmap.corba};

        header = new ArrayList<>();
        for (String tit : titles) {
            parentProvider = new ParentProvider(fotos[i], tit);
            i++;
            header.add(parentProvider);
        }

        child = new HashMap<>();
        List<ParentProvider> iskender = new ArrayList<>();
        String[] detail = {"120 gr iskender", "180 gr iskender"};
        double[] fiyat = {22, 30};
        for (String d : detail) {
            provider = new ParentProvider(R.mipmap.iskender, d, fiyat[a]);
            a++;
            iskender.add(provider);
        }
        List<ParentProvider> tombik = new ArrayList<>();
        String[] tomgram = {"50 gr tombik", "70 gr tombik", "100 gr tombik",
                "120 gr tombik", "150 gr tombik", "180 gr tombik", "200 gr tombik"};
        double[] tomfiyat = {11, 13.5, 18, 21, 27, 32, 36};
        for (String t : tomgram) {
            provider = new ParentProvider(R.mipmap.tombik, t, tomfiyat[b]);
            b++;
            tombik.add(provider);
        }
        List<ParentProvider> yarim = new ArrayList<>();
        String[] yarimgram = {"70 gr yarım", "100 gr yarım", "120 gr yarım", "150 gr yarım",
                "180 gr yarım", "200 gr yarım"};
        double[] yarimfiyat = {13.5, 18, 21, 27, 32, 36};
        for (String y : yarimgram) {
            provider = new ParentProvider(R.mipmap.yarim, y, yarimfiyat[c]);
            c++;
            yarim.add(provider);
        }
        List<ParentProvider> durum = new ArrayList<>();
        String[] durumgram = {"70 gr durum", "100 gr durum", "120 gr durum", "150 gr durum",
                "180 gr durum", "200 gr durum"};
        double[] durumfiyat = {13.5, 18, 21, 27, 32, 36};
        for (String dur : durumgram) {
            provider = new ParentProvider(R.mipmap.durum, dur, durumfiyat[d]);
            d++;
            durum.add(provider);
        }
        List<ParentProvider> porsiyon = new ArrayList<>();
        String[] porsiyongram = {"100 gr porsiyon", "120 gr porsiyon", "150 gr porsiyon",
                "180 gr porsiyon", "200 gr porsiyon", "250 gr porsiyon"};
        double[] porsiyonfiyat = {18, 21, 27, 32, 36, 45};
        for (String p : porsiyongram) {
            provider = new ParentProvider(R.mipmap.porsiyon, p, porsiyonfiyat[e]);
            e++;
            porsiyon.add(provider);
        }
        List<ParentProvider> pilav = new ArrayList<>();
        String[] pilavgram = {"100 gr pilav üstü", "120 gr pilav üstü", "150 gr pilav üstü",
                "180 gr pilav üstü", "200 gr pilav üstü", "250 gr pilav üstü"};
        int[] pilavfiyat = {21, 24, 27, 34, 38, 40};
        for (String p : pilavgram) {
            provider = new ParentProvider(R.mipmap.pilav, p, pilavfiyat[f]);
            f++;
            pilav.add(provider);
        }
        List<ParentProvider> salata = new ArrayList<>();
        String[] cesit = {"Çoban Salata", "Mevsim Salata"};
        int[] salatafiyat = {6, 6};
        for (String s : cesit) {
            provider = new ParentProvider(R.mipmap.salata, s, salatafiyat[g]);
            g++;
            salata.add(provider);
        }
        List<ParentProvider> corba = new ArrayList<>();
        String[] cesitler = {"Çorba", "Büyük Patates", "Küçük Patates"};
        int[] yanfoto = {R.mipmap.corba, R.mipmap.patates, R.mipmap.patates};
        int[] fiyatlar = {6, 9, 5};
        for (String p : cesitler) {
            provider = new ParentProvider(yanfoto[h], p, fiyatlar[h]);
            h++;
            corba.add(provider);
        }
        child.put(header.get(0), iskender);
        child.put(header.get(1), tombik);
        child.put(header.get(2), yarim);
        child.put(header.get(3), durum);
        child.put(header.get(4), porsiyon);
        child.put(header.get(5), pilav);
        child.put(header.get(6), salata);
        child.put(header.get(7), corba);

        myExpandableListAdapter = new MyExpandableListAdapter(getApplicationContext(), child, header);
        listYemek.setAdapter(myExpandableListAdapter);

        String[] icecekler = getResources().getStringArray(R.array.drinks);
        double[] drinkFiyat = {4.5, 4.5, 4.5, 2, 2, 2, 4.5, 4.5, 4, 4, 3, 3.5, 3.5};
        int[] drinkfoto = {R.mipmap.kola, R.mipmap.kola, R.mipmap.kola, R.mipmap.soda, R.mipmap.soda, R.mipmap.su, R.mipmap.fanta,
                R.mipmap.sprite, R.mipmap.salgam, R.mipmap.fusetea, R.mipmap.limonata, R.mipmap.ayran, R.mipmap.ayran};

        myListAdapter = new MyListAdapter(this, list);
        for (String i : icecekler) {
            provider = new ParentProvider(drinkfoto[x], i, drinkFiyat[x]);
            x++;
            myListAdapter.add(provider);
        }
        listDrink.setAdapter(myListAdapter);

        String[] tatlilar = getResources().getStringArray(R.array.tatli);
        int[] tatlifoto = {R.mipmap.kunefe, R.mipmap.asure, R.mipmap.tekpasta, R.mipmap.malaga,
                R.mipmap.malaga, R.mipmap.cheesecake, R.mipmap.tiramisu, R.mipmap.sutlac, R.mipmap.profi};

        mListAdapter = new MyListAdapter(this, liste);
        for (String t : tatlilar) {
            provider = new ParentProvider(tatlifoto[r], t, 10.0);
            r++;
            mListAdapter.add(provider);
        }
        listTatli.setAdapter(mListAdapter);

        listYemek.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                ParentProvider parentProvider = (ParentProvider) myExpandableListAdapter.getChild(i, i1);
                MyListAdapter myListAdapter = new MyListAdapter(getApplicationContext(), listi);
                myListAdapter.add(parentProvider);
                SharedPreferences preferences = getSharedPreferences("urun3", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                Gson gson = new Gson();
                String jsonurun = gson.toJson(listi);
                editor.putString("liste3", jsonurun);
                editor.apply();
                Toast.makeText(getApplicationContext(), "Listeye Kaydedildi", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        listDrink.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ParentProvider parentProvider = (ParentProvider) adapterView.getItemAtPosition(i);
                MyListAdapter myListAdapter = new MyListAdapter(getApplicationContext(), listi);
                myListAdapter.add(parentProvider);
                SharedPreferences preferences = getSharedPreferences("urun3", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                Gson gson = new Gson();
                String jsonurun = gson.toJson(listi);
                editor.putString("liste3", jsonurun);
                editor.apply();
                Toast.makeText(getApplicationContext(), "Listeye Kaydedildi", Toast.LENGTH_LONG).show();
            }
        });

        listTatli.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ParentProvider parentProvider = (ParentProvider) adapterView.getItemAtPosition(i);
                MyListAdapter myListAdapter = new MyListAdapter(getApplicationContext(), listi);
                myListAdapter.add(parentProvider);
                SharedPreferences preferences = getSharedPreferences("urun3", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                Gson gson = new Gson();
                String jsonurun = gson.toJson(listi);
                editor.putString("liste3", jsonurun);
                editor.apply();
                Toast.makeText(getApplicationContext(), "Listeye Kaydedildi", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void list(View view) {
        startActivity(new Intent(this, Listele3.class));
    }

}
