import {
    displayArtists
} from './artistspage.js'

const getAllArtists = () => {
    fetch('http://localhost:8080/artists/')
    .then(response => response.json())
    .then(artistJson => displayArtists(artistJson));
}

export {getAllArtists}