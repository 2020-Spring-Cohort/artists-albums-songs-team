package org.wcci.apimastery.Storage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.apimastery.models.Artist;

@Repository
public interface ArtistRepository extends CrudRepository<Artist,Long> {


}
