package com.dev.james.pokemonapi.repository;

import com.dev.james.pokemonapi.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    @Override
    boolean existsById(Integer integer);

    boolean existsByName(String name);


}