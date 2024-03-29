package com.dev.james.pokemonapi.dto;

import com.dev.james.pokemonapi.models.Pokemon;
import lombok.Data;

@Data
public class ReviewDto {
    private int id;

    private String title;
    private String content;
    private int stars;
    private Pokemon pokemon;
}
