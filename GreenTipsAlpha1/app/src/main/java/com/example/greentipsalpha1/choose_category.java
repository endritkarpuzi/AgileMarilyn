package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class choose_category extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);

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

    public void gotransport (View v){ startActivity(new Intent(choose_category.this, transportTips.class)); }
    public void gohousehold (View v){ startActivity(new Intent(choose_category.this, householdTips.class)); }
    public void gooutdoors (View v){ startActivity(new Intent(choose_category.this, outdoorsTips.class)); }
    public void gosocial (View v){ startActivity(new Intent(choose_category.this, socialTips.class)); }
    public void goworklife (View v){ startActivity(new Intent(choose_category.this, worklifeTips.class)); }

    public void returnActivity (View v){
        finish();
    }

    public void returnHome(View v){
        startActivity(new Intent(choose_category.this, welcome.class));
    }


}