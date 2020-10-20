package com.example.greentipsalpha1;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class schedule extends AppCompatActivity {

    private int NotificationId = 1;
    EditText editText;
    TimePicker timePicker;
    Button setTime, cancelTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        createNotificationChannel();

        timePicker = findViewById(R.id.time);
        setTime = findViewById(R.id.btnSet);
        cancelTime = findViewById(R.id.btnCancel);
        Spinner spinner_days = findViewById(R.id.spinner_days);

        ArrayAdapter<CharSequence> adapter_days = ArrayAdapter.createFromResource(this, R.array.days_spinner, android.R.layout.simple_spinner_item);
        adapter_days.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_days.setAdapter(adapter_days);

        spinner_days.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    language = "Engelska";
                }
                if (position == 1) {
                    language = "Svenska";
                }
                if (position == 2) {
                    language = "Spanska";
                }
                if (position == 3) {
                    language = "Franska";
                }
                if (position == 4) {
                    language = "Arabiska";
                }
                if (position == 5) {
                    language = "Syrianska";
                }
                if (position == 6) {
                    language = "Polska";
                }
                if (position == 7) {
                    language = "Albanska";
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tip = "NO TIP";
                /*String tip_res;

                Intent intent_1 = getIntent();
                String tip_trans = intent_1.getStringExtra(slidecreatortransport.EXTRA_TEXT);

                Intent intent_2 = getIntent();
                String tip_out = intent_2.getStringExtra(slidecreatoroutdoors.EXTRA_TEXT);

                Intent intent_3 = getIntent();
                String tip_soc = intent_3.getStringExtra(slidecreatorsocial.EXTRA_TEXT);

                Intent intent_4 = getIntent();
                String tip_work = intent_4.getStringExtra(slidecreatorworklife.EXTRA_TEXT);

                Intent intent_5 = getIntent();
                String tip_house = intent_5.getStringExtra(slidecreatorhousehold.EXTRA_TEXT);

                if(tip_out == null && tip_soc == null && tip_work == null && tip_house == null){

                }
                if(tip_out == null && tip_soc == null && tip_work == null && tip_house == null){

                }
                if(tip_out == null && tip_soc == null && tip_work == null && tip_house == null){

                }
                if(tip_out == null && tip_soc == null && tip_work == null && tip_house == null){

                }*/

                Bundle extras = getIntent().getExtras();
                if(extras != null){
                    tip = extras.getString("slide_content");
                }

                Intent intent_res = new Intent (Intent.ACTION_INSERT);
                intent_res.setData(CalendarContract.CONTENT_URI);

                intent_res.putExtra ("notificationId", NotificationId);
                intent_res.putExtra ("message", tip);
                final PendingIntent pendingIntent = PendingIntent.getBroadcast(schedule.this, 0,intent_res, 0);
                int Hour = timePicker.getHour();
                int Minute = timePicker.getMinute();
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY,Hour);
                calendar.set(Calendar.MINUTE,Minute);
                calendar.set(Calendar.SECOND,0);


                long alarmStartTime = calendar.getTimeInMillis();
                //long alarmStartTime = 0;
                alarmManager.set(AlarmManager.RTC_WAKEUP,alarmStartTime,pendingIntent);

                Toast.makeText(schedule.this,"Done",Toast.LENGTH_SHORT).show();

            }
        });
        cancelTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (schedule.this, AlarmReceiver.class);
                final PendingIntent pendingIntent = PendingIntent.getBroadcast(schedule.this, 0,intent, PendingIntent.FLAG_CANCEL_CURRENT);
                alarmManager.cancel(pendingIntent);
                Toast.makeText(schedule.this,"Cancel",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createNotificationChannel(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String description = "Channel for reminder";
            NotificationChannel channel = new NotificationChannel("notificationId", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(description);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

    }
}