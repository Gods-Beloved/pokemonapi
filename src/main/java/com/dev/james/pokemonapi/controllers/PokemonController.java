package com.dev.james.pokemonapi.controllers;

import com.dev.james.pokemonapi.Service.PokemonService;
import com.dev.james.pokemonapi.models.Pokemon;
import com.dev.james.pokemonapi.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/v1")
@RestController
public class PokemonController {


    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/pokemon")
    public String getAllPokemon(){

        return "Hello World";

    }

    @GetMapping("/pokemon/{id}")
    public String getPokemonDetail(
            @PathVariable("id")
            int id
    ){
        return id+"";

    }

    @PostMapping("/pokemon")
    public ResponseEntity<Pokemon> createPokemon(
            @RequestBody
            Pokemon pokemon
    ){

        Pokemon pokemonReceived = pokemonService.createPokemon(pokemon);


        return new ResponseEntity<>(pokemonReceived , HttpStatus.CREATED);

    }

    @PutMapping("/pokemon/{id}")
    public ResponseEntity<String> updatePokemon(
            @PathVariable("id")
            int id
//            @RequestBody
//            Map<String,String> body
    ){

        return new ResponseEntity<>("Update Succesfull",HttpStatus.OK);

    }

    @DeleteMapping("/pokemon/{id}")
    public ResponseEntity<String> deletePokemon(
            @PathVariable("id")
            int id
    ){
        return new ResponseEntity<>("Deleted "+id ,HttpStatus.OK);
    }

    @DeleteMapping("/pokemon")
    public ResponseEntity<String> deleteAllPokemons (){

//        pokemonService.deleteAllPokemon();

        return new ResponseEntity<>("All Pokemon's Deleted",HttpStatus.OK);


    }

}
