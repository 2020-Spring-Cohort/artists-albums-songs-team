import {
    displaySong
} from "./songPage.js"

const getSong = () => {
    fetch('http://localhost:8080/song/')
        .then(response => response.json())
        .then(SongJson => displaySong(songJSON));
}