package org.wcci.apimastery.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "title")
public class Song {
    
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String length;
    @ManyToOne
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
    
    public Song(String title, Album album) {
        this.title = title;
        this.album = album;
    }
    
    public Song(String title, Album album, String length) {
        this.title = title;
        this.album = album;
        this.length = length;
    }
    
    public Song(String length, Album album, String... comments) {
        this.length = length;
        this.album = album;
        this.comments = new ArrayList<>(Arrays.asList(comments));
    }
    
    public Song(String title, String length, Album album, Integer... ratings) {
        this.title = title;
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
    
    
    public String getLength() {
        return length;
    }
    
    public Album getAlbum() {
        return album;
    }
    
    public void setTitle(String title) {
        this.title = title;
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
