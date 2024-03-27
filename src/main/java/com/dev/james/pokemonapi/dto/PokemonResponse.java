package com.dev.james.pokemonapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class PokemonResponse {
    private String status;
    private List<PokemonDto> data;
    private int size;

}
