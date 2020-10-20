package com.example.greentipsalpha1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapterTransport extends PagerAdapter {
    int pos;
    String tip;
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapterTransport (Context context) {
        this.context = context;
    }

    public int[] slide_images2 = {
            R.drawable.number1,
            R.drawable.number2,
            R.drawable.number3,
            R.drawable.number4,
            R.drawable.number5,
            R.drawable.number6,
            R.drawable.number7,
    };


    public int[] slide_images = {
            R.drawable.lamp,
            R.drawable.lamp,
            R.drawable.lamp,
            R.drawable.lamp,
            R.drawable.lamp,
            R.drawable.lamp,
            R.drawable.lamp,
    };

    public int[] slide_headings = {
            R.string.transporttip1,
            R.string.transporttip2,
            R.string.transporttip3,
            R.string.transporttip4,
            R.string.transporttip5,
            R.string.transporttip6,
            R.string.transporttip7,
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        pos = position;

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_functionality, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        ImageView slideImageView2 = (ImageView) view.findViewById(R.id.slide_image2);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);

        slideImageView.setImageResource(slide_images[position]);
        slideImageView2.setImageResource(slide_images2[position]);
        slideHeading.setText(slide_headings[position]);

        container.addView(view);

        Button notifyMe_1 = (Button) view.findViewById(R.id.slide_heading);
        Button notifyMe_2 = (Button) view.findViewById(R.id.notify_btn);

        notifyMe_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tip = Integer.toString(slide_headings[pos]);
            }
        });

        notifyMe_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tip = Integer.toString(slide_headings[pos]);
            }
        });

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }

    public String passingData(){
        return tip;

    }
}