import {getSong} from "./songFetcher.js";
import {getAlbum, getAlbums} from "./albumFetcher.js";
import {getAllArtists, getArtist} from "./artistFetcher.js";

const body = document.querySelector('.body');

const clearView = () => {
    while (body.firstChild) {
        body.removeChild(body.firstChild);
    }
};

const addEventListener = (query, functionToRun) => {
    document.querySelectorAll(query).forEach(element => {
        element.addEventListener('click', event => {
            event.preventDefault();
            clearView();
            functionToRun(element.innerText);
        });
    });
};

addEventListener('.song h3', getSong);

addEventListener('.artist h3', getArtist);

addEventListener('.album h3', getAlbum);

addEventListener('.albums', getAlbums);

addEventListener('.artists', getAllArtists);

addEventListener('.home', clearView);