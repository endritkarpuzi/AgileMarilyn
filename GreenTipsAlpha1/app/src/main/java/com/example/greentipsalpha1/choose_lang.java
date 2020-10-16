package com.example.greentipsalpha1;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class choose_lang extends AppCompatActivity {
    public String lan = "Engelska";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_lang);
    }
    public void lan_en(View v){ lan = "Engelska"; }
    public void lan_sw(View v){ lan = "Svenska"; }
    public void lan_sp(View v){ lan = "Spanska"; }
    public void lan_fr(View v){ lan = "Franska"; }
    public void lan_ar(View v){ lan = "Arabiska"; }
    public void lan_sy(View v){ lan = "Syrianska"; }
    public void lan_po(View v){ lan = "Polska"; }
    public void lan_al(View v){ lan = "Albanska"; }

    public String getLanguage(){
        return lan;
    }
}