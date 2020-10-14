package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void chooseLangScreen(View v){ startActivity(new Intent(welcome.this, choose_lang.class)); }

    public void aboutScreen(View v){
        startActivity(new Intent(welcome.this, about.class));
    }

    public void helpScreen(View v){ startActivity(new Intent(welcome.this, ContactForm.class));
    }

    public void categoryScreen(View v){ startActivity(new Intent(welcome.this, choose_category.class)); }

    public void scheduleScreen(View v){ startActivity(new Intent(welcome.this, schedule.class)); }


}