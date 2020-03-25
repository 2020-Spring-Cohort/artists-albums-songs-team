import{
    DomMaker
    } from './DomMaker.js'
    import{
        InputMaker
    } from './InputMaker.js'
    import{getAllArtists} from './artistFetcher.js'
    
    const createNewArtistForm= ()=>{
        const form = new DomMaker('form')
                        .changeContent('Add new Artist:')
                        .appendChild(new DomMaker('Name')
                                        .changeContent('Name:')
                                        .render())
                        .appendChild(new DomMaker('Age')
                                        .changeContent('Age:')
                                        .render())
                        .appendChild(new DomMaker('Label')
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
                                        .addOnClickAction(()=>{
                                         collectData();
                                    })

                                    .render())
        return form;
    }
    
    const collectData = () =>{
        const newName = document.querySelector('.form__name');
        const newDescription = document.querySelector('.form__description');
    
        const newArtistJson = {
            "name": newName,
            "description": newDescription
        }

        fetch("http://localhost:8080/artists/", {
            method: 'POST', 
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(newArtistJson) 
          }).then(()=> getAllArtists());
    }
    
    export {createNewArtistForm}
