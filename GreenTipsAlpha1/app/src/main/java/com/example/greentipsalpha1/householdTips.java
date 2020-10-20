package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class householdTips extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_household_tips);

        //Language button
        View base = findViewById(R.id.baselayout);
        ImageButton buttonLanguage = (ImageButton) base.findViewById(R.id.languageButton);
        buttonLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotToLanguageScreen();
            }
        });

        //HouseholdTip1 button
        Button button1 = findViewById(R.id.householdtip1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(householdTips.this, slidecreatorhousehold.class);
                intent.putExtra("slide_position", 0);
                startActivity(intent);
            }
        });

        //HouseholdTip2 button
        Button button2 = findViewById(R.id.householdtip2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(householdTips.this, slidecreatorhousehold.class);
                intent.putExtra("slide_position", 1);
                startActivity(intent);
            }
        });

        //HouseholdTip3 button
        Button button3 = findViewById(R.id.householdtip3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(householdTips.this, slidecreatorhousehold.class);
                intent.putExtra("slide_position", 2);
                startActivity(intent);
            }
        });

        //HouseholdTip4 button
        Button button4 = findViewById(R.id.householdtip4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(householdTips.this, slidecreatorhousehold.class);
                intent.putExtra("slide_position", 3);
                startActivity(intent);
            }
        });

        //HouseholdTip5 button
        Button button5 = findViewById(R.id.householdtip5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(householdTips.this, slidecreatorhousehold.class);
                intent.putExtra("slide_position", 4);
                startActivity(intent);
            }
        });

        //HouseholdTip6 button
        Button button6 = findViewById(R.id.householdtip6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(householdTips.this, slidecreatorhousehold.class);
                intent.putExtra("slide_position", 5);
                startActivity(intent);
            }
        });

        //HouseholdTip7 button
        Button button7 = findViewById(R.id.householdtip7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(householdTips.this, slidecreatorhousehold.class);
                intent.putExtra("slide_position", 6);
                startActivity(intent);
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
        startActivity(new Intent(householdTips.this, welcome.class));
    }

    //public void goToHouseholdSlide(View v) { startActivity(new Intent(householdTips.this, slidecreatorhousehold.class)); }

    public void switchView(View v) { startActivity(new Intent(householdTips.this, slidecreatorhousehold.class)); }
}