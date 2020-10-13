package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class worklifeTips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worklife_tips);
    }

    public void returnActivity (View v){
        finish();
    }

    public void returnHome(View v){
        startActivity(new Intent(worklifeTips.this, welcome.class));
    }

    public void goToWorklifeSlide(View v) {
        startActivity(new Intent(worklifeTips.this, slidecreatorworklife.class));
    }

}