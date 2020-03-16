package org.wcci.apimastery.Storage;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;

import java.util.Optional;

public interface AlbumRepository extends CrudRepository<Album, Long> {

}
