package com.example.greentipsalpha1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);
    }

    public void gotToLanguageScreen(){
        Intent intent = new Intent(getContext(), choose_lang.class);
        startActivity(intent);
    }

    public abstract Context getContext();
}
