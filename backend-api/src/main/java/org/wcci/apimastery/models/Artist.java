package org.wcci.apimastery.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private Collection<Album> albums;
    @OneToMany(mappedBy = "artist")
    private Collection<Song> songs;

    public Artist(String name){
        this.name = name;
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
