package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class householdTips extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_household_tips);


        View base = findViewById(R.id.baselayout);
        ImageButton buttonLanguage = (ImageButton) base.findViewById(R.id.languageButton);
        buttonLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotToLanguageScreen();
            }
        });



        /*TextView household_tip1 = (TextView) findViewById(R.id.householdtip1);
        TextView household_tip2 = (TextView) findViewById(R.id.householdtip2);
        TextView household_tip3 = (TextView) findViewById(R.id.householdtip3);
        TextView household_tip4 = (TextView) findViewById(R.id.householdtip4);
        TextView household_tip5 = (TextView) findViewById(R.id.householdtip5);
        TextView household_tip6 = (TextView) findViewById(R.id.householdtip6);
        TextView household_tip7 = (TextView) findViewById(R.id.householdtip7);

        household_tip1.setText(t1);
        //transport_tip1.setVisibility(View.GONE);

        household_tip2.setText(t2);
        //transport_tip2.setVisibility(View.GONE);

        household_tip3.setText(t3);
        //transport_tip3.setVisibility(View.GONE);

        household_tip4.setText(t4);
        //transport_tip4.setVisibility(View.GONE)

        household_tip5.setText(t5);
        //transport_tip5.setVisibility(View.GONE);

        household_tip6.setText(t6);
        //transport_tip6.setVisibility(View.GONE);

        household_tip7.setText(t7);
        //transport_tip7.setVisibility(View.GONE);*/
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
}