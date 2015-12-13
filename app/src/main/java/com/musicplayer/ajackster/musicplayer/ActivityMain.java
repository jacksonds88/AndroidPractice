package com.musicplayer.ajackster.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityMain
        extends AppCompatActivity
        implements View.OnClickListener {

    // this method is invoked when an activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // buttonX.setOnClickListener needs to be called so the button presses can be recorded
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);  // must implement View.OnClickListener to use "this" here
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);  // must implement View.OnClickListener to use "this" here
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);  // must implement View.OnClickListener to use "this" here
    }

    // this method handles button clicks
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.button1: {
                TextView tv = (TextView)findViewById(R.id.textView);
                tv.setText("You pressed button 1");
                break;
            }

            // goes to another activity
            case R.id.button2: {
                Intent intent = new Intent(ActivityMain.this, ActivityMusic.class);
                startActivity(intent);
                finish();
                break;
            }

            case R.id.button3: {
                finish();
                System.exit(0);
                break;
            }
        }
    }
}
