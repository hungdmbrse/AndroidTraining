package com.example.mackanrishastv.question43;

class Song {
    private final String musicName;
    private final int id;
    private boolean playing;

    Song(String musicName, int id) {
        this.musicName = musicName;
        this.id = id;
        playing = false;
    }

    public String getMusicName() {
        return this.musicName;
    }

    public int getId() {
        return this.id;
    }

    public boolean isPlaying() {
        return this.playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
}
