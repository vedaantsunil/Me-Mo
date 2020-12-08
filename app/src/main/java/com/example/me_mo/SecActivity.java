package com.example.me_mo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SecActivity extends AppCompatActivity {
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent2= new Intent(SecActivity.this,MainActivity2.class);
                startActivity(intent2);
                finish();
            }
        },3000);
        TextView name = findViewById(R.id.textView);
        String username = getIntent().getStringExtra("Keyname");
        name.setText(username);
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            name.setText("Welcome to our app "+extras.getString("Keyname"));
        }
    }
}