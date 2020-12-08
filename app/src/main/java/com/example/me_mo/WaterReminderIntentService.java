package com.example.me_mo;
import android.app.IntentService;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.Nullable;


public class WaterReminderIntentService extends IntentService {
    public WaterReminderIntentService() {
        super("WaterReminderIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String action = intent.getAction();
        ReminderTask.executeTask(this,action);
    }
}
