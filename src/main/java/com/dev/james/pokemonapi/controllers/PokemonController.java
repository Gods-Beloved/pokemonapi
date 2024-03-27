package com.dev.james.pokemonapi.controllers;

import com.dev.james.pokemonapi.Service.PokemonService;
import com.dev.james.pokemonapi.Service.PokemonServiceImpl;
import com.dev.james.pokemonapi.dto.PokemonDto;
import com.dev.james.pokemonapi.dto.PokemonResponse;
import com.dev.james.pokemonapi.models.Pokemon;
import com.dev.james.pokemonapi.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.Map;

@RequestMapping("/api/v1")
@RestController
public class PokemonController {



    private PokemonServiceImpl pokemonServiceImpl;

    @Autowired
    public PokemonController(PokemonServiceImpl pokemonServiceImpl) {
        this.pokemonServiceImpl = pokemonServiceImpl;
    }

    @GetMapping("/pokemon")
    public ResponseEntity<PokemonResponse> getAllPokemon(){

       return new ResponseEntity<>(pokemonServiceImpl.getAllPokemon(),HttpStatus.OK) ;

    }

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<PokemonDto> getPokemonById(
            @PathVariable("id")
            int id
    ){
        return new ResponseEntity<>(pokemonServiceImpl.getPokemonById(id),HttpStatus.OK);


    }

    @PostMapping("/pokemon")
    public ResponseEntity<PokemonDto> createPokemon(
            @RequestBody
            PokemonDto pokemonDto
    ){

        System.out.println(pokemonDto);

        return new ResponseEntity<>( pokemonServiceImpl.createPokemon(pokemonDto), HttpStatus.CREATED);

    }

    @PutMapping("/pokemon/{id}")
    public ResponseEntity<PokemonDto> updatePokemon(
            @PathVariable("id")
            int id,
           @RequestBody
            PokemonDto pokemonDto
//            Map<String,String> body
    ){

        return new ResponseEntity<>(pokemonServiceImpl.updatePokemonById(pokemonDto,id),HttpStatus.OK);

    }
//
//    @DeleteMapping("/pokemon/{id}")
//    public ResponseEntity<String> deletePokemon(
//            @PathVariable("id")
//            int id
//    ){
//        return new ResponseEntity<>("Deleted "+id ,HttpStatus.OK);
//    }
//
    @DeleteMapping("/pokemon")
    public ResponseEntity<String> deleteAllPokemons (){

        pokemonServiceImpl.deleteAllPokemon();

//        pokemonService.deleteAllPokemon();

        return new ResponseEntity<>("All Pokemon's Deleted",HttpStatus.OK);


    }

}