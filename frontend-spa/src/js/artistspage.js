import { ArtistCreator } from './artistCreator.js';

const artistBody = document.querySelector('.body');

const displayArtist = (artist) => {
    artistBody.appendChild(new ArtistCreator()
    .setName(artist.name)
    .setImage(artist.image)
    .setAlbums(artist.albums)
    .setAge(artist.age)
    .setLabel(artist.label).render());
}

export {
    displayArtist
}