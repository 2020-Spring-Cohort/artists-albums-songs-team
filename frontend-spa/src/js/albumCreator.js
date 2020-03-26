class AlbumCreator {

    constructor() {
        this._container = document.createElement('div');
        this._title = document.createElement('h3');
        this._label = document.createElement('h4');
        this._songs = document.createElement('ul');
    }

    render() {
        this._container.className = 'album';
        this._container.append(this._title);
        this._container.append(this._label);
        this._container.append(this._songs);
        return this._container;
    }

    setTitle(title) {
        this._title.innerText = title;
        return this;
    }

    setLabel(label) {
        this._label.innerText = label;
        return this;
    }

    addSong(song) {
        let newElement = document.createElement('li');
        newElement.innerText = song.title;
        this._songs.appendChild(newElement);
        return this;
    }

}

export {
    AlbumCreator
}