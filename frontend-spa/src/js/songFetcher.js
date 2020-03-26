import {displaySong} from './songPage.js'

const getSong = (name) => {

    fetch("http://localhost:8080/songs/" + name)
        .then(res => {
            const bodyElement = document.querySelector('.body');
            while (bodyElement.firstChild) {
                bodyElement.removeChild(bodyElement.firstChild);
            }
            return res;
        })
        .then(res => res.json())
        .then(song => displaySong(song))
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

export {getSong, getSongs}