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

public class SliderAdapterTransport extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapterTransport (Context context) {
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