package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class worklifeTips extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worklife_tips);

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

    public void returnActivity (View v){
        finish();
    }

    public void returnHome(View v){
        startActivity(new Intent(worklifeTips.this, welcome.class));
    }

    public void goToWorklifeSlide(View v) { startActivity(new Intent(worklifeTips.this, slidecreatorworklife.class)); }

    public void switchView(View v) { startActivity(new Intent(worklifeTips.this, slidecreatorworklife.class)); }

}