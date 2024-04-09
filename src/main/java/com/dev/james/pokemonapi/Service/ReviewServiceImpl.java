package com.dev.james.pokemonapi.Service;

import com.dev.james.pokemonapi.dto.PokemonDto;
import com.dev.james.pokemonapi.dto.ReviewDto;
import com.dev.james.pokemonapi.exceptions.PokemonNotFoundException;
import com.dev.james.pokemonapi.exceptions.ReviewNotFoundException;
import com.dev.james.pokemonapi.models.Pokemon;
import com.dev.james.pokemonapi.models.Review;
import com.dev.james.pokemonapi.repository.PokemonRepository;
import com.dev.james.pokemonapi.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService{


    private PokemonRepository pokemonRepository;

    private ReviewRepository reviewRepository;


    @Autowired
    public ReviewServiceImpl(PokemonRepository pokemonRepository,ReviewRepository reviewRepository) {
        this.pokemonRepository = pokemonRepository;
        this.reviewRepository = reviewRepository;

    }



    @Override
    public ReviewDto storeReview(ReviewDto reviewDto  ) {

        Pokemon pokemon = pokemonRepository.findById(reviewDto.getId()).orElseThrow(() -> new PokemonNotFoundException("No such pokemon to update"));

        Review review = new Review();
        review.setContent(reviewDto.getContent());
        review.setStars(reviewDto.getStars());
        review.setTitle(reviewDto.getTitle());
        review.setStars(reviewDto.getStars());
        review.setPokemon(pokemon);

       Review newReview = reviewRepository.save(review);

       ReviewDto reviewDto1 = new ReviewDto();
       reviewDto1.setContent(newReview.getContent());
        reviewDto1.setId(review.getId());
        reviewDto1.setStars(review.getStars());
        reviewDto1.setTitle(review.getTitle());
        reviewDto1.setStars(review.getStars());
        reviewDto1.setPokemon(review.getPokemon());

        return reviewDto1;


    }

    @Override
    public List<ReviewDto> getReviewByPokemonId(int id) {

       List<Review> reviews = reviewRepository.findByPokemonId(id);

       return reviews.stream().map( review -> mapToDto(review)).collect(Collectors.toList());

    }

    @Override
    public ReviewDto getReviewById(int reviewId, int pokemonId) {

        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(() -> new PokemonNotFoundException("Pokemon not found"));

        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new ReviewNotFoundException("Review not found"));

        if (review.getPokemon().getId() != pokemon.getId() ){
            throw new ReviewNotFoundException("Review no associated with Pokemon");
        }

        return mapToDto(review);


    }

    @Override
    public ReviewDto updateReviewById(int pokemonId, int reviewId, ReviewDto reviewDto) {

        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(() -> new PokemonNotFoundException("Pokemon not found"));


        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new ReviewNotFoundException("Review not found"));

        if (review.getPokemon().getId() != pokemon.getId() ){
            throw new ReviewNotFoundException("Review no associated with Pokemon");
        }

        review.setTitle(reviewDto.getTitle());
        review.setContent(reviewDto.getContent());
        review.setStars(reviewDto.getStars());

        Review updateReview = reviewRepository.save(review);

        return mapToDto(updateReview);



    }

    private ReviewDto mapToDto(Review review){
        ReviewDto reviewDto1 = new ReviewDto();
        reviewDto1.setContent(review.getContent());
//        reviewDto1.setId(review.getId());
        reviewDto1.setStars(review.getStars());
        reviewDto1.setTitle(review.getTitle());
        reviewDto1.setStars(review.getStars());
//        reviewDto1.setPokemon(review.getPokemon());

        return reviewDto1;
    }


//    @Override
//    public List<ReviewDto> getReviewByPokemonId(int id) {
//
//    }
}
