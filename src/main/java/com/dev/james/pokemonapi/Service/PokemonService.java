package com.dev.james.pokemonapi.Service;

import com.dev.james.pokemonapi.dto.PokemonDto;
import com.dev.james.pokemonapi.dto.PokemonResponse;
import com.dev.james.pokemonapi.models.Pokemon;

import java.util.List;

public interface PokemonService {

    PokemonDto createPokemon(PokemonDto pokemonDto);

    PokemonResponse getAllPokemon();

   List<PokemonDto> getAllPokes(int paneNo,int pageSize);


    PokemonDto getPokemonById(int id);

    PokemonDto updatePokemonById(PokemonDto pokemonDto,int id);

    void deletePokemonById(int id);

    void deleteAllPokemon();
}
