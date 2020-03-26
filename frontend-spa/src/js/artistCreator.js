class ArtistCreator{

    constructor(){
        this._container = document.createElement("div");
        this._name = document.createElement("h3");
        this._image = document.createElement("img");
        this._albums = document.createElement("ul");
        this._label = document.createElement("p");
        this._age = document.createElement("p");
    }

    render(){
        this._container.className = 'artist';
        this._container.append(this._name);
        this._container.append(this._image);
        this._container.append(this._albums);
        this._container.append(this._label);
        this._container.append(this._age);
        return this._container;
    }

    setName(name) {
        this._name.innerText = name;
        return this;
    }

    setImage(image) {
        this._image.setAttribute('src', image);
        this._image.setAttribute('alt', image);
        return this;
    }

    setAlbums(albums) {
        albums.forEach(album => {
            let newListElem = document.createElement('li');
            newListElem.innerText = album.title;
            this._albums.appendChild(newListElem);
        });
        return this;
    }

    setLabel(label) {
        this._label.innerText = label;
        return this;
    }

    setAge(age) {
        this._age.innerText = age;
        return this;
    }
}

export {
    ArtistCreator
}