package com.example.me_mo;

import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;


public class mDialogPref extends DialogPreference {

    private Context ctx;

    public mDialogPref(Context context, AttributeSet attrs) {
        super(context, attrs);
        ctx = context;
    }

    // along with constructors, you will want to override
    @Override
    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);

    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
        super.onDialogClosed(positiveResult);

        if (positiveResult) {
            ctx.deleteDatabase(DB.DB_NAME);
        }
    }
}