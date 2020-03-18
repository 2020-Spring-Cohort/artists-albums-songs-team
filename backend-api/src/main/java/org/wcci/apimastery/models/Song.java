package org.wcci.apimastery.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Song {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @ManyToOne
    private Artist artist;
    private String length;
    @ManyToOne
    private Album album;
    
    protected Song() {
    }
    
    public Song(String title) {
        this.title = title;
    }
    
    public Song(String title, Artist artist) {
        this.title = title;
        this.artist = artist;
    }
    
    public Song(String title, Artist artist, Album album) {
        this.title = title;
        this.artist = artist;
        this.album = album;
    }
    
    public Song(String title, Artist artist, Album album, String length) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.length = length;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public Artist getArtist() {
        return artist;
    }
    
    public String getLength() {
        return length;
    }
    
    public Album getAlbum() {
        return album;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    
    public void setLength(String length) {
        this.length = length;
    }
    
    public void setAlbum(Album album) {
        this.album = album;
    }
}
