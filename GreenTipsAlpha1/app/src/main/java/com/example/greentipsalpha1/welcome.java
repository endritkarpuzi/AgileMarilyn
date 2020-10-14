package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class welcome extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        View base = findViewById(R.id.baselayout);
        ImageButton buttonLanguage = (ImageButton) base.findViewById(R.id.languageButton);
        buttonLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotToLanguageScreen();
            }
        });
    }

    @Override
    public Context getContext() {
        return this;
    }

    public void chooseLangScreen(View v){ startActivity(new Intent(welcome.this, choose_lang.class)); }

    public void aboutScreen(View v){
        startActivity(new Intent(welcome.this, about.class));
    }

    public void helpScreen(View v){
        startActivity(new Intent(welcome.this, help.class));
    }

    public void categoryScreen(View v){ startActivity(new Intent(welcome.this, choose_category.class)); }

    public void scheduleScreen(View v){ startActivity(new Intent(welcome.this, schedule.class)); }


}