package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class socialTips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_tips);
    }

    public void returnActivity (View v){
        finish();
    }

    public void returnHome(View v){
        startActivity(new Intent(socialTips.this, welcome.class));
    }

    public void goToSocialSlide(View v) { startActivity(new Intent(socialTips.this, slidecreatorsocial.class)); }

    public void switchView(View v) { startActivity(new Intent(socialTips.this, slidecreatorsocial.class)); }
}