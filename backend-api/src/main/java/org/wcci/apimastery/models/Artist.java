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
    private String numberOfBlackShirts;
    @OneToMany(mappedBy = "artist")
    private Collection<Album> albums;
    @OneToMany(mappedBy = "artist")
    private Collection<Song> songs;

}
