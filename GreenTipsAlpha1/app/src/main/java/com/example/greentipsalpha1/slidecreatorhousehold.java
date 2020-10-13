package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class slidecreatorhousehold extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private SliderAdapterHousehold sliderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidelayout);
        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        sliderAdapter = new SliderAdapterHousehold(this);
        mSlideViewPager.setAdapter(sliderAdapter);
    }
}
