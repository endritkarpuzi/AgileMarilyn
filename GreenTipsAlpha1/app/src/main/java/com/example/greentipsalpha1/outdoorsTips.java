package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class outdoorsTips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoors_tips);
    }

    public void returnActivity (View v){
        finish();
    }

    public void returnHome(View v){
        startActivity(new Intent(outdoorsTips.this, welcome.class));
    }

    public void goToOutdoorsSlide(View v) {
        startActivity(new Intent(outdoorsTips.this, slidecreatoroutdoors.class));
    }
}