package com.example.me_mo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private CardView monochromeMode, zenMode, notificationMode, pieMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        monochromeMode = (CardView) findViewById(R.id.monochrome_card);
        zenMode = (CardView) findViewById(R.id.zen_card);
        pieMode = (CardView) findViewById(R.id.pie_card);
        notificationMode = (CardView) findViewById(R.id.notif_card);
        monochromeMode.setOnClickListener(this);
        zenMode.setOnClickListener(this);
        pieMode.setOnClickListener(this);
        notificationMode.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.monochrome_card:
                i = new Intent(this, mono.class);
                startActivity(i);
                break;
            case R.id.zen_card:
                i = new Intent(this, zen.class);
                startActivity(i);
                break;
            case R.id.pie_card:
                i = new Intent(this, pie.class);
                startActivity(i);
                break;
            case R.id.notif_card:
                i = new Intent(this, notif.class);
                startActivity(i);
                break;
            default:
                break;


        }


    }
}