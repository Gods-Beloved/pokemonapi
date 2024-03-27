package com.dev.james.pokemonapi.Service;

import com.dev.james.pokemonapi.models.Pokemon;
import com.dev.james.pokemonapi.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> getAllPokemons(){
       return pokemonRepository.findAll();
    }

    public Optional<Pokemon> getPokemon(int id){
        boolean exist = pokemonRepository.existsById(id);

        if (exist){
            return pokemonRepository.findById(id);
        }
        return Optional.empty();
    }


    public Pokemon createPokemon(Pokemon pokemon){

            return pokemonRepository.save(pokemon);

    }

    public void deleteAllPokemon(){
        pokemonRepository.deleteAll();
    }


}
