package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class slidecreatorsocial extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private SliderAdapterSocial sliderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidelayout);
        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        sliderAdapter = new SliderAdapterSocial(this);
        mSlideViewPager.setAdapter(sliderAdapter);
    }
}
