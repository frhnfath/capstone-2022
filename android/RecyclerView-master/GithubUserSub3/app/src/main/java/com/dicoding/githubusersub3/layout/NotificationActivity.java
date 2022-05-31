package com.dicoding.githubusersub3.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.dicoding.githubusersub3.R;
import com.dicoding.githubusersub3.notification.NotificationBroadcast;

import java.util.Calendar;

public class NotificationActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private Switch dailySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int dailyReminder = sharedPreferences.getInt("user_reminder", 0);
        dailySwitch = findViewById(R.id.notification_switch);
        if (dailyReminder == 1) {
            dailySwitch.setChecked(true);
        } else {
            dailySwitch.setChecked(false);
        }
        onSwitch();
    }

    private void onSwitch() {
        dailySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setNotificationOn(getApplicationContext());
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("user_reminder", 1);
                    editor.commit();
                    Toast.makeText(NotificationActivity.this, "Notification enabled", Toast.LENGTH_SHORT).show();
                } else {
                    setNotificationOff(getApplicationContext());
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("user_reminder", 0);
                    editor.commit();
                    Toast.makeText(NotificationActivity.this, "Notification Disabled", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setNotificationOff(Context applicationContext) {
        Log.d("aSwitch","aSwitch");
        Intent intent = new Intent(NotificationActivity.this, NotificationBroadcast.class);
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(applicationContext, 102, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        if (alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }

    private void setNotificationOn(Context applicationContext) {
        Intent intent = new Intent(applicationContext, com.dicoding.githubusersub3.notification.NotificationBroadcast.class);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,9);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(applicationContext, 102, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("aSwitch","aSwitch");
        if (alarmManager != null){
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
        }
    }
}