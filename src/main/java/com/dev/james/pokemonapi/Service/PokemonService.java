package com.dev.james.pokemonapi.Service;

import com.dev.james.pokemonapi.dto.PokemonDto;
import com.dev.james.pokemonapi.dto.PokemonResponse;

public interface PokemonService {

    PokemonDto createPokemon(PokemonDto pokemonDto);

    PokemonResponse getAllPokemon();


    PokemonDto getPokemonById(int id);

    PokemonDto updatePokemonById(PokemonDto pokemonDto,int id);



    void deleteAllPokemon();
}
