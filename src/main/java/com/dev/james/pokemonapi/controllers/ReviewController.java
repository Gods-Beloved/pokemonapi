package com.dev.james.pokemonapi.controllers;

import com.dev.james.pokemonapi.Service.ReviewServiceImpl;
import com.dev.james.pokemonapi.dto.ReviewDto;
import com.dev.james.pokemonapi.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1")
@RestController
public class ReviewController {

  private ReviewServiceImpl reviewServiceImpl;

  @Autowired
    public ReviewController(ReviewServiceImpl reviewServiceImpl) {
        this.reviewServiceImpl = reviewServiceImpl;
    }

    @PostMapping("/review")
    public ResponseEntity<ReviewDto> storeReview(
            @RequestBody
            ReviewDto reviewDto
    ){

        return new ResponseEntity<ReviewDto>(reviewServiceImpl.storeReview(reviewDto), HttpStatus.CREATED);

    }

    @GetMapping("review/{id}")
    public ResponseEntity<List<ReviewDto>> getReviewsById(
            @PathVariable(value = "id")
            int id

    ){
      return new ResponseEntity<List<ReviewDto>>(      reviewServiceImpl.getReviewByPokemonId(id),HttpStatus.OK
      );
    }




}
