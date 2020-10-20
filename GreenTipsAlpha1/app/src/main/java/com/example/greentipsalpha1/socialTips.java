package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class socialTips extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_tips);

        //Language button
        View base = findViewById(R.id.baselayout);
        ImageButton buttonLanguage = (ImageButton) base.findViewById(R.id.languageButton);
        buttonLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotToLanguageScreen();
            }
        });

        //SocialTip1 button
        Button button1 = findViewById(R.id.socialtip1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(socialTips.this, slidecreatorsocial.class);
                intent.putExtra("slide_position", 0);
                startActivity(intent);
            }
        });

        //SocialTip2 button
        Button button2 = findViewById(R.id.socialtip2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(socialTips.this, slidecreatorsocial.class);
                intent.putExtra("slide_position", 1);
                startActivity(intent);
            }
        });

        //SocialTip3 button
        Button button3 = findViewById(R.id.socialtip3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(socialTips.this, slidecreatorsocial.class);
                intent.putExtra("slide_position", 2);
                startActivity(intent);
            }
        });

        //SocialTip4 button
        Button button4 = findViewById(R.id.socialtip4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(socialTips.this, slidecreatorsocial.class);
                intent.putExtra("slide_position", 3);
                startActivity(intent);
            }
        });

        //SocialTip5 button
        Button button5 = findViewById(R.id.socialtip5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(socialTips.this, slidecreatorsocial.class);
                intent.putExtra("slide_position", 4);
                startActivity(intent);
            }
        });

        //SocialTip6 button
        Button button6 = findViewById(R.id.socialtip6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(socialTips.this, slidecreatorsocial.class);
                intent.putExtra("slide_position", 5);
                startActivity(intent);
            }
        });

        //SocialTip7 button
        Button button7 = findViewById(R.id.socialtip7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(socialTips.this, slidecreatorsocial.class);
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
        startActivity(new Intent(socialTips.this, welcome.class));
    }

    public void switchView(View v) { startActivity(new Intent(socialTips.this, slidecreatorsocial.class)); }
}