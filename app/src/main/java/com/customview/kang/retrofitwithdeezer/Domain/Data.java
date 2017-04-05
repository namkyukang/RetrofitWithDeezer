package com.customview.kang.retrofitwithdeezer.Domain;

/**
 * Created by kang on 2017-04-05.
 */

public class Data {
    private int id;
    private int readable;
    private String title;
    private String title_short;
    private String title_version;
    private String link;
    private String duration;
    private String rank;
    private boolean explicit_lyrics;
    private String preview;

    private artist artist;
    private album album;

    private String track;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReadable() {
        return readable;
    }

    public void setReadable(int readable) {
        this.readable = readable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_short() {
        return title_short;
    }

    public void setTitle_short(String title_short) {
        this.title_short = title_short;
    }

    public String getTitle_version() {
        return title_version;
    }

    public void setTitle_version(String title_version) {
        this.title_version = title_version;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public boolean isExplicit_lyrics() {
        return explicit_lyrics;
    }

    public void setExplicit_lyrics(boolean explicit_lyrics) {
        this.explicit_lyrics = explicit_lyrics;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public com.customview.kang.retrofitwithdeezer.Domain.artist getArtist() {
        return artist;
    }

    public void setArtist(com.customview.kang.retrofitwithdeezer.Domain.artist artist) {
        this.artist = artist;
    }

    public com.customview.kang.retrofitwithdeezer.Domain.album getAlbum() {
        return album;
    }

    public void setAlbum(com.customview.kang.retrofitwithdeezer.Domain.album album) {
        this.album = album;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }
}
