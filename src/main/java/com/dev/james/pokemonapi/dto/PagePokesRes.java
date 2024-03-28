package com.dev.james.pokemonapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class PagePokesRes {
    private List<PokemonDto> content;
    private int pageNo ;
    private int pageSize ;
    private Long totalElements;
    private int totalPages;
    private boolean last;
}
