class SongCreator{

     constructor(){
         this._container = document.createElement("div");
         this._title = document.createElement("h3");
         this._artist = document.createElement("h4");
         this._album = document.createElement("p");
         this._length = document.createElement("p");
     }

     render(){
         this._container.className = "song";
         this._container.appendChild (this._title);
         this._container.appendChild(this._artist);
         this._container.appendChild(this._album);
         this._container.appendChild(this._length);
     }

     setTitle(title){
         this._title.innerText = title;
         return this;
     }

     setArtist(artist){
        this._artist.innerText = artist;
         return this;
     }

     setAlbum(album){
        this._album.innerText = album;
        return this;
    }

    setLength(length){
        this._length.innerText = length;
        return this;
    }


}
export {SongCreator}