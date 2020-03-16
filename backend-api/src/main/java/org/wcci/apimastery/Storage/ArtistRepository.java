package org.wcci.apimastery.Storage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.apimastery.models.Artist;

import java.util.Optional;

@Repository
public interface ArtistRepository extends CrudRepository<Artist,Long> {
    Optional<Artist> findArtistById(Long id);

}
