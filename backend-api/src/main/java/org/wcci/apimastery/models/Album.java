package org.wcci.apimastery.models;

import javax.persistence.*;
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
    private Collection<Song> songs;
    @ManyToOne
    private Artist artist;

    public Album() {
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
