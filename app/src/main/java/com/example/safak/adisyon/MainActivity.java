package com.example.safak.adisyon;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.example.safak.adisyon.masalar.Masa1;
import com.example.safak.adisyon.masalar.Masa10;
import com.example.safak.adisyon.masalar.Masa11;
import com.example.safak.adisyon.masalar.Masa12;
import com.example.safak.adisyon.masalar.Masa2;
import com.example.safak.adisyon.masalar.Masa3;
import com.example.safak.adisyon.masalar.Masa4;
import com.example.safak.adisyon.masalar.Masa5;
import com.example.safak.adisyon.masalar.Masa6;
import com.example.safak.adisyon.masalar.Masa7;
import com.example.safak.adisyon.masalar.Masa8;
import com.example.safak.adisyon.masalar.Masa9;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void buton(View view){startActivity(new Intent(this,Masa1.class));}
    public void buton2(View view){startActivity(new Intent(this,Masa2.class));}
    public void buton3(View view){startActivity(new Intent(this,Masa3.class));}
    public void buton4(View view){startActivity(new Intent(this,Masa4.class));}
    public void buton5(View view){startActivity(new Intent(this,Masa5.class));}
    public void buton6(View view){startActivity(new Intent(this,Masa6.class));}
    public void buton7(View view){startActivity(new Intent(this,Masa7.class));}
    public void buton8(View view){startActivity(new Intent(this,Masa8.class));}
    public void buton9(View view){startActivity(new Intent(this,Masa9.class));}
    public void buton10(View view){startActivity(new Intent(this,Masa10.class));}
    public void buton11(View view){startActivity(new Intent(this,Masa11.class));}
    public void buton12(View view){startActivity(new Intent(this,Masa12.class));}
}
