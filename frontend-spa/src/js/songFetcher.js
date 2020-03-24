import {displaySong} from './songPage.js'

const getSong = (id) => {

    fetch("http://localhost:8080/songs/" + id)
        .then(res => {
            const bodyElement = document.querySelector('.body');
            while (bodyElement.firstChild) {
                bodyElement.removeChild(bodyElement.firstChild);
            }
            return res;
        })
        .then(res => res.json())
        .then(song => displaySong(song))
        .then(() => alert('Bleed'))
        .catch(err => console.error(err))
};

const getSongs = () => {
    fetch("http://localhost:8080/songs")
        .then(res => {
            const bodyElement = document.querySelector('.body');
            while (bodyElement.firstChild) {
                bodyElement.removeChild(bodyElement.firstChild);
            }
            return res;
        })
        .then(res => res.json())
        .then(array => {
            array.forEach(displaySong);
        })
        .then(() => alert('All songs'));
};

getSongs();

getSong('Bleed');

getSong('God of Emptiness');