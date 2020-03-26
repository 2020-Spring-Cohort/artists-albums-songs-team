import {AlbumCreator} from "./albumCreator.js";

const displayAlbum = (album) => {
    let bodyElement = document.querySelector('.body');

    bodyElement.appendChild(new AlbumCreator()
        .setLabel(album.label)
        .setTitle(album.title)
        .addSong(album.songs)
        .render());
};

export {
    displayAlbum
}