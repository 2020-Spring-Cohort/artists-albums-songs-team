import {SongCreator} from "./songCreator.js";

const bodyElement = document.querySelector('.body');

const displaySong = (song) => {
    bodyElement.appendChild(new SongCreator().setAlbum(song.album.title)
        .setArtist(song.artist.name)
        .setTitle(song.title).render());
};

export {
    displaySong
}