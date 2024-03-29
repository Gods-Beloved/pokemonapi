package com.dev.james.pokemonapi.repository;

import com.dev.james.pokemonapi.models.Pokemon;
import com.dev.james.pokemonapi.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    @Override
    boolean existsById(Integer integer);

//    List<Review> findByPokemonId(int pokemonId);


}