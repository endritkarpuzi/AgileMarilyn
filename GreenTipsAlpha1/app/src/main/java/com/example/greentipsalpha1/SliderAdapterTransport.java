package com.example.greentipsalpha1;

import android.content.Context;
import android.content.Intent;
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

public class SliderAdapterTransport extends PagerAdapter {
    SQLiteDatabase db;
    DatabaseHelper dbHelper;
    String lan;

    String t1 = " ";
    String t2 = " ";
    String t3 = " ";
    String t4 = " ";
    String t5 = " ";
    String t6 = " ";
    String t7 = " ";

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

    public int[] slide_headings;

    /*public String[] slide_strings;*/

    /*
    public int[] slide_headings = {
            R.string.transporttip1,
            R.string.transporttip2,
            R.string.transporttip3,
            R.string.transporttip4,
            R.string.transporttip5,
            R.string.transporttip6,
            R.string.transporttip7,
    };
    */


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

        Intent intent = new Intent();
        lan = intent.getStringExtra(choose_lang.EXTRA_LAN);

        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getReadableDatabase();
        try {
            dbHelper.CheckDb();
        }catch (Exception e){e.printStackTrace();}
        try {
            dbHelper.OpenDatabase();
        }catch (Exception e){e.printStackTrace();}

        databaseInput();

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_functionality, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        ImageView slideImageView2 = (ImageView) view.findViewById(R.id.slide_image2);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);

        slideImageView.setImageResource(slide_images[position]);
        slideImageView2.setImageResource(slide_images2[position]);
        slideHeading.setText(slide_headings[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }

    public void databaseInput(){

        Cursor tip1 = dbHelper.getTip("1", lan);
        t1 = tip1.getString(0);

        Cursor tip2 = dbHelper.getTip("2", lan);
        t2 = tip2.getString(0);

        Cursor tip3 = dbHelper.getTip("3", lan);
        t3 = tip3.getString(0);

        Cursor tip4 = dbHelper.getTip("4", lan);
        t4 = tip4.getString(0);

        Cursor tip5 = dbHelper.getTip("5", lan);
        t5 = tip5.getString(0);

        Cursor tip6 = dbHelper.getTip("6", lan);
        t6 = tip6.getString(0);

        Cursor tip7 = dbHelper.getTip("7", lan);
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