package org.wcci.apimastery.models;

import javax.persistence.*;

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

    public Song() {
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

    public Album getAlbum(){
        return album;
    }
}
