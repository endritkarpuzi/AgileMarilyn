package com.example.greentipsalpha1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class transportTips extends AppCompatActivity {

    SQLiteDatabase db;
    DatabaseHelper dbHelper;
    choose_lang lan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_tips);

        dbHelper = new DatabaseHelper(getApplicationContext());
        db = dbHelper.getReadableDatabase();

        TextView transport_tip1 = (TextView) findViewById(R.id.transportip1);
        Cursor tip1 = dbHelper.getTip("1", lan.getLanguage());
        String t1 = null;
        if (tip1.moveToFirst()){
            t1 = tip1.getString(0);
        }
        transport_tip1.setText(t1);
        transport_tip1.setVisibility(View.GONE);

        TextView transport_tip2 = (TextView) findViewById(R.id.transportip2);
        Cursor tip2 = dbHelper.getTip("2", lan.getLanguage());
        String t2 = null;
        if (tip2.moveToFirst()){
            t2 = tip2.getString(0);
        }
        transport_tip2.setText(t2);
        transport_tip2.setVisibility(View.GONE);

        TextView transport_tip3 = (TextView) findViewById(R.id.transportip3);
        Cursor tip3 = dbHelper.getTip("3", lan.getLanguage());
        String t3 = null;
        if (tip3.moveToFirst()){
            t3 = tip3.getString(0);
        }
        transport_tip3.setText(t3);
        transport_tip3.setVisibility(View.GONE);

        TextView transport_tip4 = (TextView) findViewById(R.id.transportip4);
        Cursor tip4 = dbHelper.getTip("4", lan.getLanguage());
        String t4 = null;
        if (tip4.moveToFirst()){
            t4 = tip4.getString(0);
        }
        transport_tip4.setText(t4);
        transport_tip4.setVisibility(View.GONE);

        TextView transport_tip5 = (TextView) findViewById(R.id.transportip5);
        Cursor tip5 = dbHelper.getTip("5", lan.getLanguage());
        String t5 = null;
        if (tip5.moveToFirst()){
            t5 = tip5.getString(0);
        }
        transport_tip5.setText(t5);
        transport_tip5.setVisibility(View.GONE);

        TextView transport_tip6 = (TextView) findViewById(R.id.transportip6);
        Cursor tip6 = dbHelper.getTip("6", lan.getLanguage());
        String t6 = null;
        if (tip6.moveToFirst()){
            t6 = tip6.getString(0);
        }
        transport_tip6.setText(t6);
        transport_tip6.setVisibility(View.GONE);

        TextView transport_tip7 = (TextView) findViewById(R.id.transportip7);
        Cursor tip7 = dbHelper.getTip("7", lan.getLanguage());
        String t7 = null;
        if (tip7.moveToFirst()){
            t7 = tip7.getString(0);
        }
        transport_tip7.setText(t7);
        transport_tip7.setVisibility(View.GONE);
    }

    public void returnActivity (View v){
        finish();
    }

    public void returnHome(View v){
        startActivity(new Intent(transportTips.this, welcome.class));
    }

    public void goToTransportSlide(View v) {
        startActivity(new Intent(transportTips.this, transportslide.class));
    }
}