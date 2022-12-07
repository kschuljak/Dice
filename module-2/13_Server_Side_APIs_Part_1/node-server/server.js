// needed to host web server
const express = require('express')
const bodyParser = require('body-parser')
// needed for file writing
const fs = require('fs')


// load data from json file (this is my database)
let characters = require('./data/characters.json')
let movies = require('./data/movies.json')


// configure the server
const app = express()
app.use(bodyParser.json({extended: true}))


// map the url path listeners
app.get('/', getRoot)
// characters
app.get('/characters', getAllCharacters)
app.get('/characters/:id', getCharacterById)
app.post('/characters', addCharacter)
app.put('/characters/:id', updateCharacter)
app.delete('/characters/:id', deleteCharacter)
// movies
app.get('/movies', getAllMovies)
app.get('/movies/:id', getMovieById)


// start the server
const server = app.listen(3000, () =>{

    const host = server.address().address
    const port = server.address().port

    console.log(`Node Server listeing at http://${host}:${port}`)
})


// root endpoint
function getRoot(request, response) 
{
    response.send('Welcome to the Marvel Miniverse')
}


// characters
function getAllCharacters(request, response)
{
    const json = JSON.stringify(characters);
    response.setHeader('content-type', 'application/json')
    response.send(json)
}

function getCharacterById(request, response)
{
    const id = request.params.id

    const character = characters.find(c => c.id == id)
    const json = JSON.stringify(character);
    response.setHeader('content-type', 'application/json')
    response.send(json)
}

function addCharacter(request, response)
{    
    const character = request.body
    character.id = nextCharacterId()

    characters.push(character)
    
    const json = JSON.stringify(characters, null, 4);
    fs.writeFile('./data/characters.json', json,(err) =>{
        if(err)
            console.log(err);
        else
            console.log(`${character.name} was added to ./data/characters.json`);
    });

    response.setHeader('content-type', 'application/json')
    response.status(201)
    response.send(JSON.stringify(character))
}

function updateCharacter(request, response) 
{

    const character = request.body
    character.id = parseInt(request.params.id)

    characters = characters.filter(c => c.id != character.id)
    characters.push(character)
    characters = characters.sort((a, b) => a.id - b.id)
    
    const json = JSON.stringify(characters, null, 4);
    fs.writeFile('./data/characters.json', json,(err) => {
        if(err)
            console.log(err)
        else
            console.log(`${character.name} has been updated to ./data/characters.json`)
    });

    response.sendStatus(200)
}

function deleteCharacter(request, response)
{

    const id = parseInt(request.params.id)

    characters = characters.filter(c => c.id != id)
    
    const json = JSON.stringify(characters, null, 4);
    fs.writeFile('./data/characters.json', json,(err) => {
        if(err)
            console.log(err)
        else
            console.log(`Character ${id} was deleted from ./data/characters.json`)
    });

    response.sendStatus(204)
}

// character helper functions
function nextCharacterId()
{
    const id = characters.map(c => c.id)
                         .reduce((max, num) => max < num ? num : max)

    return id + 1
}


// movies
function getAllMovies(request, response)
{
    const json = JSON.stringify(movies);
    response.setHeader('content-type', 'application/json')
    response.send(json)
}

function getMovieById(request, response)
{
    const id = request.params.id

    const movie = movies.find(c => c.id == id)
    const json = JSON.stringify(movie);
    response.setHeader('content-type', 'application/json')
    response.send(json)
}

