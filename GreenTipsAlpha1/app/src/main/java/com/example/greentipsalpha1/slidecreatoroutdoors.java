package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class slidecreatoroutdoors extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.greentipsalpha1.EXTRA_TEXT";
    private ViewPager mSlideViewPager;
    private SliderAdapterOutdoors sliderAdapter;

    Context context;
    LayoutInflater layoutInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidelayout);
        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        sliderAdapter = new SliderAdapterOutdoors(this);
        mSlideViewPager.setAdapter(sliderAdapter);

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_functionality, null, false);

        Button notifyMe_1 = (Button) view.findViewById(R.id.slide_heading);
        Button notifyMe_2 = (Button) view.findViewById(R.id.slide_heading);

        notifyMe_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passingData();
            }
        });

        notifyMe_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passingData();
            }
        });
    }

    public void passingData(){
        Intent intent = new Intent(this, ScheduleTimeActivity.class);
        intent.putExtra("slide_content", sliderAdapter.passingData());
        startActivity(intent);
    }
}