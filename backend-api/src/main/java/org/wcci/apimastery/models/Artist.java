package org.wcci.apimastery.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Artist {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    private String imageLink;
    private String label;
    @OneToMany(mappedBy = "artist")
    @JsonBackReference
    private Collection<Album> albums;
    @OneToMany(mappedBy = "artist")
    @JsonBackReference
    private Collection<Song> songs;

    public Artist(String name){
        this.name = name;
    }

    public Artist(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Artist(String name, int age, String imageLink){
        this.name = name;
        this.age = age;
        this.imageLink = imageLink;
    }

    public Artist(String name, int age, String imageLink, String label) {
        this.age = age;
        this.imageLink = imageLink;
        this.label = label;
        this.name = name;
    }

    public Artist(String name, int age, String imageLink, String label, Album... albums) {
        this.age = age;
        this.imageLink = imageLink;
        this.label = label;
        this.name = name;
        this.albums = new ArrayList<>(Arrays.asList(albums));
    }

    public Artist(String name, int age, String imageLink, String label, Song... songs) {
        this.age = age;
        this.imageLink = imageLink;
        this.label = label;
        this.name = name;
        this.songs = new ArrayList<>(Arrays.asList(songs));
    }

    public Artist() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getImageLink() {
        return imageLink;
    }

    public String getLabel() {
        return label;
    }

    public Collection<Album> getAlbums() {
        return albums;
    }

    public Collection<Song> getSongs() {
        return songs;
    }
}
