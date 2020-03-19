package org.wcci.apimastery.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Song {
    
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @ManyToOne
    @JsonManagedReference
    private Artist artist;
    private String length;
    @ManyToOne
    @JsonManagedReference
    private Album album;
    @ElementCollection
    private List<String> comments;
    @ElementCollection
    private List<Integer> ratings;
    
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
    
    public Song(Artist artist, String length, Album album, String... comments) {
        this.artist = artist;
        this.length = length;
        this.album = album;
        this.comments = new ArrayList<>(Arrays.asList(comments));
    }
    
    public Song(String title, Artist artist, String length, Album album, Integer... ratings) {
        this.title = title;
        this.artist = artist;
        this.length = length;
        this.album = album;
        this.ratings = new ArrayList<>(Arrays.asList(ratings));
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
    
    public List<String> getComments() {
        return comments;
    }
    
    public List<Integer> getRatings() {
        return ratings;
    }
}
