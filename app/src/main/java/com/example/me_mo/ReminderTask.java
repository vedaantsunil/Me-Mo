package com.example.me_mo;

import android.content.Context;

import com.example.me_mo.NotificationUtils;
import com.example.me_mo.PreferenceUtils;



public class ReminderTask {

    public static final String ACTION_INCREMENT_WATER_COUNT = "increment-water-count";
    public static final String ACTION_DISMISS_NOTIFICATION = "dismiss-notification";
    public static final String ACTION_CHARGING_REMINDER = "charging-reminder";



    private static void incrementWaterCount(Context context)
    {
        PreferenceUtils.incrementWeatherCount(context);
        NotificationUtils.clearAllNotification(context);

    }

    public static void executeTask(Context context, String action)
    {
        if (ACTION_INCREMENT_WATER_COUNT.equals(action))
        {
            incrementWaterCount(context);
        }else if (ACTION_DISMISS_NOTIFICATION.equals(action))
        {
            NotificationUtils.clearAllNotification(context);
        }
        else if (ACTION_CHARGING_REMINDER.equals(action))
        {
            issueChargingReminder(context);
        }

    }

    private static void issueChargingReminder(Context context) {

        PreferenceUtils.incrementWeatherCount(context);
        NotificationUtils.remindUserBecauseCharging(context);
    }


}
