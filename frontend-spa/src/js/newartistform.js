import {DomMaker} from './DomMaker.js'
import {getAllArtists} from './artistFetcher.js'

const createNewArtistForm = () => {
    return new DomMaker('form')
        .changeContent('Add new Artist:')
        .appendChild(new DomMaker('input')
            .changeContent('Name:')
            .render())
        .appendChild(new DomMaker('input')
            .changeContent('Age:')
            .render())
        .appendChild(new DomMaker('input')
            .addClassName('form__description')
            .render())
        .appendChild(new DomMaker('Albums')
            .addClassName('form__description')
            .render())
        .appendChild(new DomMaker('Songs')
            .addClassName('form__description')
            .render())
        .appendChild(new DomMaker('button')
            .changeContent('Submit New Artist')
            .addOnClickAction(() => {
                collectData();
            })

            .render());
};

const collectData = () => {
    const newName = document.querySelector('.form__name');
    const newDescription = document.querySelector('.form__description');

    const newArtistJson = {
        "name": newName,
        "description": newDescription
    };

    fetch("http://localhost:8080/artists/", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newArtistJson)
    }).then(() => getAllArtists());
};

export {createNewArtistForm}
