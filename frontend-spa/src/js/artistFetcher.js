import {displayArtist} from './artistspage.js'

const getAllArtists = () => {
    fetch('http://localhost:8080/artists/')
        .then(response => {
            const bodyElement = document.querySelector(".body");
            while (bodyElement.firstChild) {
                bodyElement.removeChild(bodyElement.firstChild);
            }
            return response;
        })
        .then(response => response.json())
        .then(array => array.forEach(displayArtist))
        .catch(err => console.error(err));
};

const getArtist = (name) => {
    fetch("http://localhost:8080/artist/" + name)
        .then(response => {
            const bodyElement = document.querySelector(".body");
            while (bodyElement.firstChild) {
                bodyElement.removeChild(bodyElement.firstChild);
            }
            return response;
        })
        .then(response => response.json())
        .then(artist => displayArtist(artist))
        .then(() => alert('Single Artist'))
        .catch(err => console.error(err))
};

getAllArtists();

export {getAllArtists, getArtist}