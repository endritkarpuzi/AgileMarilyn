package com.example.greentipsalpha1;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ScheduleTimeActivity extends AppCompatActivity {

    private int NotificationId = 1;
    EditText editText;
    TimePicker timePicker;
    Button setTime, cancelTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        createNotificationChannel();

        editText = findViewById(R.id.et);
        timePicker = findViewById(R.id.time);
        setTime = findViewById(R.id.btnSet);
        cancelTime = findViewById(R.id.btnCancel);

        final AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (ScheduleTimeActivity.this, AlarmReceiver.class);
                intent.putExtra ("notificationId", NotificationId);
                intent.putExtra ("message", editText.getText().toString());
                final PendingIntent pendingIntent = PendingIntent.getBroadcast(ScheduleTimeActivity.this, 0,intent, 0);
                int Hour = timePicker.getHour();
                int Minute = timePicker.getMinute();
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY,Hour);
                calendar.set(Calendar.MINUTE,Minute);
                calendar.set(Calendar.SECOND,0);


                long alarmStartTime = calendar.getTimeInMillis();
                //long alarmStartTime = 0;
                alarmManager.set(AlarmManager.RTC_WAKEUP,alarmStartTime,pendingIntent);

                Toast.makeText(ScheduleTimeActivity.this,"Done",Toast.LENGTH_SHORT).show();

            }
        });
        cancelTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (ScheduleTimeActivity.this, AlarmReceiver.class);
                final PendingIntent pendingIntent = PendingIntent.getBroadcast(ScheduleTimeActivity.this, 0,intent, PendingIntent.FLAG_CANCEL_CURRENT);
                alarmManager.cancel(pendingIntent);
                Toast.makeText(ScheduleTimeActivity.this,"Cancel",Toast.LENGTH_SHORT).show();
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