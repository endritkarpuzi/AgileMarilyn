package com.example.greentipsalpha1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;


import androidx.appcompat.app.AppCompatActivity;

public class choose_lang extends AppCompatActivity {
    public String lan = "Engelska";
    public static final String EXTRA_LAN = "com.example.greentipsalpha1.EXTRA_LAN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_lang);

        getLanguage();

    }

    public void lan_en(View v){ lan = "Engelska"; }
    public void lan_sw(View v){ lan = "Svenska"; }
    public void lan_sp(View v){ lan = "Spanska"; }
    public void lan_fr(View v){ lan = "Franska"; }
    public void lan_ar(View v){ lan = "Arabiska"; }
    public void lan_sy(View v){ lan = "Syrianska"; }
    public void lan_po(View v){ lan = "Polska"; }
    public void lan_al(View v){ lan = "Albanska"; }

    public void getLanguage() {
        Intent intent_trans = new Intent(this, SliderAdapterTransport.class);
        intent_trans.putExtra(EXTRA_LAN, lan);
        startActivity(intent_trans);

        Intent intent_out = new Intent(this, SliderAdapterOutdoors.class);
        intent_out.putExtra(EXTRA_LAN, lan);
        startActivity(intent_out);

        Intent intent_soc = new Intent(this, SliderAdapterSocial.class);
        intent_soc.putExtra(EXTRA_LAN, lan);
        startActivity(intent_soc);

        Intent intent_work = new Intent(this, SliderAdapterWorklife.class);
        intent_work.putExtra(EXTRA_LAN, lan);
        startActivity(intent_work);

        Intent intent_house = new Intent(this, SliderAdapterHousehold.class);
        intent_house.putExtra(EXTRA_LAN, lan);
        startActivity(intent_house);
    }

    public void showPopup(){
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window_layout, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        popupWindow.showAtLocation(findViewById(R.id.language_layout), Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    public void returnActivity (View v){
        finish();
    }

    public void returnHome(View v){
        startActivity(new Intent(choose_lang.this, welcome.class));
    }

    public void changeLang(String s){
        LocaleHelper.setLocale(this, s);
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);

    }

    public void englishButton(final View v){
        showPopup();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                changeEnglish(v);
            }
        }, 5000);

    }

    public void changeEnglish(View v) {
        changeLang("en");
    }

    public void swedishButton(final View v){
        showPopup();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                changeSwedish(v);
            }
        }, 5000);
    }

    public void changeSwedish(View v) {
        changeLang("sv");
    }

    public void frenchButton(final View v){
        showPopup();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                changeFrench(v);
            }
        }, 5000);
    }

    public void changeFrench(View v) {
        changeLang("fr");
    }

    public void spanishButton(final View v){
        showPopup();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                changeSpanish(v);
            }
        }, 5000);
    }

    public void changeSpanish(View v) {
        changeLang("es");
    }

    public void arabicButton(final View v){
        showPopup();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                changeArabic(v);
            }
        }, 5000);
    }

    public void changeArabic(View v) {
        changeLang("ar");
    }

    public void polishButton(final View v){
        showPopup();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                changePolish(v);
            }
        }, 5000);
    }

    public void changePolish(View v) {
        changeLang("pl");
    }

    public void albanianButton(final View v){
        showPopup();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                changeAlbanian(v);
            }
        }, 5000);
    }

    public void changeAlbanian(View v) {
        changeLang("al");
    }
}