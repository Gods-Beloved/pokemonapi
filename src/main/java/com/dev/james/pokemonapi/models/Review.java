package com.dev.james.pokemonapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Review {

    private int id;
    private String title;
    private String content;
    private int starts;

}
