package com.musicplayer.ajackster.musicplayer;

/**
 * Created by david.jackson on 12/16/15.
 */
public class Song {
    private String title;
    private int audioFile;
    private int imageFile;

    public Song(String title, int audioFile, int imageFile)
    {
        this.title = title;
        this.audioFile = audioFile;
        this.imageFile = imageFile;
    }

    public String getTitle()
    {
        return title;
    }

    public int getAudioFile()
    {
        return audioFile;
    }

    public int getImageFile()
    {
        return imageFile;
    }
}
