package com.example.greentipsalpha1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapterSocial extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapterSocial (Context context) {
        this.context = context;
    }

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
            R.string.socialtip1,
            R.string.socialtip2,
            R.string.socialtip3,
            R.string.socialtip4,
            R.string.socialtip5,
            R.string.socialtip6,
            R.string.socialtip7,
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

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_functionality, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}