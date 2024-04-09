package com.dev.james.pokemonapi.Service;

import com.dev.james.pokemonapi.dto.ReviewDto;

import java.util.List;


public interface ReviewService {

    ReviewDto storeReview (ReviewDto reviewDto );

    List<ReviewDto> getReviewByPokemonId(int id);

    ReviewDto getReviewById(int reviewId,int pokemonId);

    ReviewDto updateReviewById(int pokemonId ,int reviewId , ReviewDto reviewDto);

    void deleteReviewById(int reviewId,int pokemonId);
}
