package com.dev.james.pokemonapi.repository;

import com.dev.james.pokemonapi.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Integer> {

    List<Review> findByPokemonId(int id);

}
