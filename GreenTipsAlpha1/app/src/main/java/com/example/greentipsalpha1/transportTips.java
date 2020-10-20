package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class transportTips extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_tips);

        //Language button
        View base = findViewById(R.id.baselayout);
        ImageButton buttonLanguage = (ImageButton) base.findViewById(R.id.languageButton);
        buttonLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotToLanguageScreen();
            }
        });

        //TransportTip1 button
        Button button1 = findViewById(R.id.transporttip1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(transportTips.this, slidecreatortransport.class);
                intent.putExtra("slide_position", 0);
                startActivity(intent);
            }
        });

        //TransportTip2 button
        Button button2 = findViewById(R.id.transporttip2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(transportTips.this, slidecreatortransport.class);
                intent.putExtra("slide_position", 1);
                startActivity(intent);
            }
        });

        //TransportTip3 button
        Button button3 = findViewById(R.id.transporttip3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(transportTips.this, slidecreatortransport.class);
                intent.putExtra("slide_position", 2);
                startActivity(intent);
            }
        });

        //TransportTip4 button
        Button button4 = findViewById(R.id.transporttip4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(transportTips.this, slidecreatortransport.class);
                intent.putExtra("slide_position", 3);
                startActivity(intent);
            }
        });

        //TransportTip5 button
        Button button5 = findViewById(R.id.transporttip5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(transportTips.this, slidecreatortransport.class);
                intent.putExtra("slide_position", 4);
                startActivity(intent);
            }
        });

        //TransportTip6 button
        Button button6 = findViewById(R.id.transporttip6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(transportTips.this, slidecreatortransport.class);
                intent.putExtra("slide_position", 5);
                startActivity(intent);
            }
        });

        //TransportTip7 button
        Button button7 = findViewById(R.id.transporttip7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(transportTips.this, slidecreatortransport.class);
                intent.putExtra("slide_position", 6);
                startActivity(intent);
            }
        });

    }

    @Override
    public Context getContext() {
        return this;
    }

    public void returnHome(View v){
        startActivity(new Intent(transportTips.this, welcome.class));
    }

    public void switchView(View v) { startActivity(new Intent(transportTips.this, slidecreatortransport.class)); }


}