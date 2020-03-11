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

}
