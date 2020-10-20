package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class slidecreatorhousehold extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private SliderAdapterHousehold sliderAdapter;
    int position;

    Context context;
    LayoutInflater layoutInflater;

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
        Intent intent = new Intent(this, schedule.class);
        intent.putExtra("slide_content", sliderAdapter.passingData());
        startActivity(intent);
    }
}
