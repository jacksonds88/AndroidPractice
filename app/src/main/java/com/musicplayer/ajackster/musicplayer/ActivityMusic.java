package com.musicplayer.ajackster.musicplayer;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityMusic extends AppCompatActivity implements View.OnClickListener {

    // this link is really helpful:
    // http://developer.android.com/guide/topics/media/mediaplayer.html
    private MediaPlayer mediaPlayer = null;
    private TextView tv;
    private int [] songs = {R.raw.tuesday, R.raw.whatdoyoumean, R.raw.everybody};
    private String [] namesOfSongs = {"Tuesday", "What Do You Mean", "Everybody"};
    private int incrementSong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button bStartMusic = (Button) findViewById(R.id.bStartMusic);
        bStartMusic.setOnClickListener(this);

        Button bNext = (Button) findViewById(R.id.bNext);
        bNext.setOnClickListener(this);

        Button bPrevious = (Button) findViewById(R.id.bPrevious);
        bPrevious.setOnClickListener(this);

        Button bStopMusic = (Button) findViewById(R.id.bStopMusic);
        bStopMusic.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1: {
                Intent intent = new Intent(ActivityMusic.this, ActivityMain.class);
                startActivity(intent);
                finish();
                break;
            }

            case R.id.bStartMusic: {
                mediaPlayer = MediaPlayer.create(this, songs[incrementSong]);
                mediaPlayer.start(); // no need to call prepare(); create() does that for you
                tv = (TextView) findViewById(R.id.textTitle);
                tv.setText(namesOfSongs[incrementSong]);
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                break;
            }
            case R.id.bNext: {
                if (incrementSong >= 2) {
                    incrementSong = 0;
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(this, songs[incrementSong]);
                    mediaPlayer.start();
                    tv = (TextView) findViewById(R.id.textTitle);
                    tv.setText(namesOfSongs[incrementSong]);
                    tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                } else {
                    incrementSong++;
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(this, songs[incrementSong]);
                    mediaPlayer.start();
                    tv = (TextView) findViewById(R.id.textTitle);
                    tv.setText(namesOfSongs[incrementSong]);
                    tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                }
                break;
            }
            case R.id.bPrevious: {
                if (incrementSong <= 0) {
                    incrementSong = 2;
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(this, songs[2]);
                    mediaPlayer.start();
                    tv = (TextView)findViewById(R.id.textTitle);
                    tv.setText(namesOfSongs[incrementSong]);
                    tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                } else {
                    mediaPlayer.stop();
                    incrementSong--;
                    mediaPlayer = MediaPlayer.create(this, songs[incrementSong]);
                    mediaPlayer.start();
                    tv = (TextView)findViewById(R.id.textTitle);
                    tv.setText(namesOfSongs[incrementSong]);
                    tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                }
                break;
            }
            case R.id.bStopMusic: {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                    tv = (TextView)findViewById(R.id.textTitle);
                    tv.setText("Music");
                    tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    break;
                }
            }
        }
    }
}

