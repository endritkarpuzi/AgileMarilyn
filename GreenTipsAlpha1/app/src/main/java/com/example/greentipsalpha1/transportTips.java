package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class transportTips extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
        }catch (NullPointerException ignored){

        }
        setContentView(R.layout.activity_transport_tips);


        View base = findViewById(R.id.baselayout);
        ImageButton buttonLanguage = (ImageButton) base.findViewById(R.id.languageButton);
        buttonLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotToLanguageScreen();
            }
        });


        /*TextView transport_tip1 = (TextView) findViewById(R.id.transportip1);
        TextView transport_tip2 = (TextView) findViewById(R.id.transportip2);
        TextView transport_tip3 = (TextView) findViewById(R.id.transportip3);
        TextView transport_tip4 = (TextView) findViewById(R.id.transportip4);
        TextView transport_tip5 = (TextView) findViewById(R.id.transportip5);
        TextView transport_tip6 = (TextView) findViewById(R.id.transportip6);
        TextView transport_tip7 = (TextView) findViewById(R.id.transportip7);

        transport_tip1.setText(t1);
        //transport_tip1.setVisibility(View.GONE);

        transport_tip2.setText(t2);
        //transport_tip2.setVisibility(View.GONE);

        transport_tip3.setText(t3);
        //transport_tip3.setVisibility(View.GONE);

        transport_tip4.setText(t4);
        //transport_tip4.setVisibility(View.GONE)

        transport_tip5.setText(t5);
        //transport_tip5.setVisibility(View.GONE);

        transport_tip6.setText(t6);
        //transport_tip6.setVisibility(View.GONE);

        transport_tip7.setText(t7);
        //transport_tip7.setVisibility(View.GONE);*/
    }

    /*@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("s", "hello");
    }*/
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
    }

    @Override
    public Context getContext() {
        return this;
    }


    public void returnActivity (View v){
        finish();
    }

    public void returnHome(View v){
        startActivity(new Intent(transportTips.this, welcome.class));
    }

    public void goToTransportSlide(View v) { startActivity(new Intent(transportTips.this, slidecreatortransport.class)); }


    public void switchView(View v) { startActivity(new Intent(transportTips.this, slidecreatortransport.class)); }


}