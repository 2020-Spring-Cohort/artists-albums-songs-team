import {displayAlbum} from "./albumPage.js";

const getAlbum = (name) => {
    fetch(`http://localhost:8080/albums/${name}`)
        .then(res => res.json())
        .then(displayAlbum)
        .catch(err => console.error(err));
};

const getAlbums = () => {
    fetch("http://localhost:8080/albums")
        .then(res => res.json())
        .then(array => array.forEach(displayAlbum))
        .catch(err => console.error(err));
};

export {getAlbum, getAlbums}
