package com.musicplayer.ajackster.musicplayer;

import android.content.Intent;
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
    private Song[] songs;
    private int songIndex = 0;

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

        songs = initializeSongs();
    }

    // returns an array of songs
    private Song[] initializeSongs()
    {
        Song[] songs = new Song[3];
        songs[0] = new Song("Tuesday", R.raw.tuesday, -1);
        songs[1] = new Song("What Do You Mean", R.raw.whatdoyoumean, -1);
        songs[2] = new Song("Everybody", R.raw.everybody, -1);
        return songs;
    }

    private void startMusic(int i)
    {
        mediaPlayer = MediaPlayer.create(this, songs[i].getAudioFile());
        mediaPlayer.start();
        tv = (TextView) findViewById(R.id.textTitle);
        tv.setText(songs[i].getTitle());
    }

    private int nonNegativeModulus(int x, int n)
    {
        int r = x % n;
        if (r < 0)
            r += n;
        return r;
    }

    private void stopMusic()
    {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
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
                startMusic(songIndex);
                break;
            }
            case R.id.bNext: {
                stopMusic();
                songIndex++;
                songIndex %= songs.length;
                startMusic(songIndex);

                break;
            }
            case R.id.bPrevious: {
                stopMusic();
                songIndex--;
                songIndex = nonNegativeModulus(songIndex, songs.length);
                startMusic(songIndex);

                break;
            }
            case R.id.bStopMusic: {
                stopMusic();
                tv = (TextView)findViewById(R.id.textTitle);
                tv.setText("None");
                break;
            }
        }
    }
}

