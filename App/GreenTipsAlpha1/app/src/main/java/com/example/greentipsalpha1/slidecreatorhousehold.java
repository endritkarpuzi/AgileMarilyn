package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class slidecreatorhousehold extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private SliderAdapterHousehold sliderAdapter;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidelayout);
        position = 0;

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            position = extras.getInt("slide_position");
        }

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        sliderAdapter = new SliderAdapterHousehold(this);
        mSlideViewPager.setAdapter(sliderAdapter);

        mSlideViewPager.setCurrentItem(position);
    }

}
