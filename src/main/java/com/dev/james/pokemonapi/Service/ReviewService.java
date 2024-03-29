package com.dev.james.pokemonapi.Service;

import com.dev.james.pokemonapi.dto.ReviewDto;

import java.util.List;


public interface ReviewService {

    ReviewDto storeReview (ReviewDto reviewDto );

    List<ReviewDto> getReviewByPokemonId(int id);
}