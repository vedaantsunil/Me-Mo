package com.example.me_mo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class notif extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {


    private TextView mWaterCountDisplay;
    private TextView mCHargingCountDisplay;
    private ImageView mChargingImageViewer;

    private Toast mToast;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif);

        //This will help us to get a View.

        mWaterCountDisplay = (TextView) findViewById(R.id.tv_water_count);
        mCHargingCountDisplay = (TextView) findViewById(R.id.tv_charging_reminder_count);
        mChargingImageViewer = (ImageView) findViewById(R.id.iv_power_increment);

        updateCount();
        updateCHargingReminderCount();

        ReminderUtils.scheduleChargingReminder(this);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        pref.registerOnSharedPreferenceChangeListener(this);


    }

    private void updateCount()
    {
        int waterCount = PreferenceUtils.getWaterCount(this);
        mWaterCountDisplay.setText(String.valueOf(waterCount));
    }

    private void updateCHargingReminderCount ()
    {
        int chargingReminder = PreferenceUtils.getChargingReminderCount(this);
        String formattedChargingReminder = getResources().getQuantityString(
                R.plurals.charge_notification_count, chargingReminder, chargingReminder);
        mCHargingCountDisplay.setText(formattedChargingReminder);
    }

    // This method will use to show increased water count in toast....
    public void  incrementWater(View view){

        if (mToast != null) mToast.cancel();
        mToast = Toast.makeText(this,R.string.water_chug_toast,Toast.LENGTH_SHORT);
        mToast.show();

        Intent incrementWaterCountIntent = new Intent(this, WaterReminderIntentService.class);
        incrementWaterCountIntent.setAction(ReminderTask.ACTION_INCREMENT_WATER_COUNT);
        startService(incrementWaterCountIntent);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        pref.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (PreferenceUtils.KEY_WATER_COUNT.equals(key))
        {
            updateCount();
        }else if(PreferenceUtils.KEY_CHARGING_REMINDER_COUNT.equals(key))
        {
            updateCHargingReminderCount();
        }

    }
}
