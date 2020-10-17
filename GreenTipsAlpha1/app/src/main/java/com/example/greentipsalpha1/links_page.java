package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class links_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links_page);


        View base = findViewById(R.id.baselayout);


        };


    public void returnActivity (View v){
        finish();
    }
    public void returnHome(View v){
        startActivity(new Intent(links_page.this, welcome.class));
    }

        };





