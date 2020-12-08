package com.example.me_mo;

import android.app.backup.*;
import android.os.ParcelFileDescriptor;
import android.util.Log;

import java.io.IOException;


public class mBackupAgent extends BackupAgentHelper {

    public static final String LOG_TAG = "BU";
    static final String PREFS = "com.vaya.unlockcounter_preferences";

    static final String PREFS_BACKUP_KEY = "prefs";
    static final String FILES_BACKUP_KEY = "myfiles";


    @Override
    public void onCreate() {
        FileBackupHelper helperData = new FileBackupHelper(this,
                "../databases/" + DB.DB_NAME);

        SharedPreferencesBackupHelper helperPrefs = new SharedPreferencesBackupHelper(this, PREFS);

        addHelper(PREFS_BACKUP_KEY, helperPrefs);
        addHelper(FILES_BACKUP_KEY, helperData);
        Log.d(LOG_TAG, "backup agent created !");
    }

    @Override
    public void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
                         ParcelFileDescriptor newState) throws IOException {
        Log.d(LOG_TAG, "backing up app data");
        synchronized (DB.sDataLock) {
            super.onBackup(oldState, data, newState);
        }
    }

    @Override
    public void onRestore(BackupDataInput data, int appVersionCode,
                          ParcelFileDescriptor newState) throws IOException {
        Log.d(LOG_TAG, "restoring up app data");
        synchronized (DB.sDataLock) {
            super.onRestore(data, appVersionCode, newState);
        }
    }

}

