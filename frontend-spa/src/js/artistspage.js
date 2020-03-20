import {DomMaker} from './DomMaker.js'
import {createNewArtistForm} from './NewArtistForm.js'

const artistPic = document.querySelector('.artistPic');

const displayArtists = (artists) => {
    artistPic.innerHTML = '';
    let artistList = new DomMaker('ul')
        .changeContent('List of artists:');
    artists.forEach((artist) => {
        artistList.appendChild(new DomMaker('li')
            .changeContent(artist.imageLink)
            .render())
    });

    anchorElement.append(artistList.render());
    anchorElement.append(createNewArtistForm());
}


export {
    displayArtists
}