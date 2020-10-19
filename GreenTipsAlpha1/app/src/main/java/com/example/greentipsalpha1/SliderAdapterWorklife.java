package com.example.greentipsalpha1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapterWorklife extends PagerAdapter {
    SQLiteDatabase db;
    DatabaseHelper dbHelper;
    choose_lang lan;

    String t1 = " ";
    String t2 = " ";
    String t3 = " ";
    String t4 = " ";
    String t5 = " ";
    String t6 = " ";
    String t7 = " ";

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapterWorklife (Context context) {
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

    public int[] slide_headings;

    /*public int[] slide_headings = {
            R.string.worklifetip1,
            R.string.worklifetip2,
            R.string.worklifetip3,
            R.string.worklifetip4,
            R.string.worklifetip5,
            R.string.worklifetip6,
            R.string.worklifetip7,
    };*/

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
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getReadableDatabase();

        databaseInput();

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_functionality, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        ImageView slideImageView2 = (ImageView) view.findViewById(R.id.slide_image2);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideImageView2.setImageResource(slide_images2[position]);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }

    public void databaseInput(){
        Cursor tip1 = dbHelper.getTip("22", lan.getLanguage());
        t1 = tip1.getString(0);

        Cursor tip2 = dbHelper.getTip("23", lan.getLanguage());
        t2 = tip2.getString(0);

        Cursor tip3 = dbHelper.getTip("24", lan.getLanguage());
        t3 = tip3.getString(0);

        Cursor tip4 = dbHelper.getTip("25", lan.getLanguage());
        t4 = tip4.getString(0);

        Cursor tip5 = dbHelper.getTip("26", lan.getLanguage());
        t5 = tip5.getString(0);

        Cursor tip6 = dbHelper.getTip("27", lan.getLanguage());
        t6 = tip6.getString(0);

        Cursor tip7 = dbHelper.getTip("28", lan.getLanguage());
        t7 = tip7.getString(0);

        slide_headings[0] = Integer.parseInt(t1);
        slide_headings[1] = Integer.parseInt(t2);
        slide_headings[2] = Integer.parseInt(t3);
        slide_headings[3] = Integer.parseInt(t4);
        slide_headings[4] = Integer.parseInt(t5);
        slide_headings[5] = Integer.parseInt(t6);
        slide_headings[6] = Integer.parseInt(t7);
    }
}