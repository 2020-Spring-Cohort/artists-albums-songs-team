package org.wcci.apimastery.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Album {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String imageLink;
    private String label;
    @OneToMany
    @JsonBackReference
    private Collection<Song> songs;
    @ManyToOne
    @JsonBackReference
    private Artist artist;

    public Album(String title, Artist artist){
        this.title = title;
        this.artist = artist;
    }
    public Album() {
    }

    public Album(String title, Artist artist,String label, String imageLink){
        this.title = title;
        this.artist = artist;
        this.label = label;
        this.imageLink = imageLink;
    }

    public Album(String title, Artist artist, String imageLink){
        this.title = title;
        this.artist = artist;
        this.imageLink = imageLink;
    }

    public Album(String title, Artist artist, Song... songs) {
        this.title = title;
        this.artist = artist;
        this.songs = new ArrayList<>(Arrays.asList(songs));
    }



    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageLink() {
        return imageLink;
    }

    public String getLabel() {
        return label;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    public Artist getArtist() {
        return artist;
    }
}
