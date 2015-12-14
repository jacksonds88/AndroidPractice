package com.musicplayer.ajackster.musicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMusic extends AppCompatActivity implements View.OnClickListener {

    // this link is really helpful:
    // http://developer.android.com/guide/topics/media/mediaplayer.html
    private MediaPlayer mediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);  // must implement View.OnClickListener to use "this" here

        Button bPlayMusic = (Button)findViewById(R.id.bPlayMusic);
        bPlayMusic.setOnClickListener(this);  // must implement View.OnClickListener to use "this" here

        Button bStopMusic = (Button)findViewById(R.id.bStopMusic);
        bStopMusic.setOnClickListener(this);  // must implement View.OnClickListener to use "this" here
    }

    // this method handles button clicks
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1: {
                Intent intent = new Intent(ActivityMusic.this, ActivityMain.class);
                startActivity(intent);
                finish();
                break;
            }

            case R.id.bPlayMusic: {
                mediaPlayer = MediaPlayer.create(this, R.raw.tuesday);
                mediaPlayer.start(); // no need to call prepare(); create() does that for you
                break;
            }

            case R.id.bStopMusic: {
                if(mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();  // releases this resource on device
                    mediaPlayer = null;
                    break;
                }
            }
        }
    }
}
