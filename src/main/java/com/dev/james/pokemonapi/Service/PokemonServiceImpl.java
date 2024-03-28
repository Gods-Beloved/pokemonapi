package com.dev.james.pokemonapi.Service;

import com.dev.james.pokemonapi.dto.PagePokesRes;
import com.dev.james.pokemonapi.dto.PokemonDto;
import com.dev.james.pokemonapi.dto.PokemonResponse;
import com.dev.james.pokemonapi.exceptions.PokemonNotFoundException;
import com.dev.james.pokemonapi.models.Pokemon;
import com.dev.james.pokemonapi.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService{

    private PokemonRepository pokemonRepository;

    @Autowired
    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public PokemonDto createPokemon(PokemonDto pokemonDto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());

       Pokemon newPokemon = pokemonRepository.save(pokemon);

        PokemonDto pokemonResponse = new PokemonDto();
        pokemonResponse.setId(newPokemon.getId());
        pokemonResponse.setName(newPokemon.getName());
        pokemonResponse.setType(newPokemon.getType());



        return pokemonDto ;
    }

    @Override
    public PokemonResponse getAllPokemon() {


        List<PokemonDto> pokemonList =  pokemonRepository.findAll().stream().map(
                pokemon -> mapToDto(pokemon)

        ).collect(Collectors.toList());

//      pokemonRepository.findAll().forEach(
//              pokemon -> {
//
//
//                  pokemonList.add(
//                         pokemonDto
//                  );
////                  pokemonList.setId(pokemon.getId());
////                  pokemonList.setType(pokemon.getType());
////                  pokemonList.setName(pokemonList.getName());
//              }
//      );



      PokemonResponse pokemonResponse = new PokemonResponse();
      pokemonResponse.setData(pokemonList);
      pokemonResponse.setSize(pokemonList.size());
      pokemonResponse.setStatus("Success");

      return pokemonResponse;

    }

    @Override
    public PagePokesRes getAllPokes(int paneNo, int pageSize) {

        Pageable pageable = PageRequest.of(paneNo,pageSize);

        Page<Pokemon> pokemonPage = pokemonRepository.findAll(pageable);

        List<Pokemon> pokemonList = pokemonPage.getContent();

     List<PokemonDto> listContents = pokemonList.stream().map(
                pokemon -> mapToDto(pokemon)

        ).collect(Collectors.toList());

        PagePokesRes paginationResponse = new PagePokesRes();

        paginationResponse.setContent(listContents);
        paginationResponse.setPageNo(pokemonPage.getNumber());
        paginationResponse.setPageSize(pokemonPage.getSize());
        paginationResponse.setTotalElements(pokemonPage.getTotalElements());
        paginationResponse.setTotalPages(pokemonPage.getTotalPages());
        paginationResponse.setLast(pokemonPage.isLast());

        return paginationResponse;


    }

    @Override
    public PokemonDto getPokemonById(int id) {
        Pokemon pokemon = pokemonRepository
                .findById(id).
                orElseThrow(()->new PokemonNotFoundException("No Such pokemon found"));


       return mapToDto(pokemon);
    }

    @Override
    public PokemonDto updatePokemonById(PokemonDto pokemonDto, int id) {
         Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(()->new PokemonNotFoundException("Pokemon update failed"));

         pokemon.setType(pokemonDto.getType());
         pokemon.setName(pokemonDto.getName());

          Pokemon updatedPokemon =  pokemonRepository.save(pokemon);

          return mapToDto(updatedPokemon);
    }

    @Override
    public void deletePokemonById(int id) {

        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(()->new PokemonNotFoundException("No such content to delete"));
        pokemonRepository.delete(pokemon);

    }


    private PokemonDto mapToDto(Pokemon pokemon){
        PokemonDto pokemonDto = new PokemonDto();

        pokemonDto.setName(pokemon.getName());
        pokemonDto.setId(pokemon.getId());
        pokemonDto.setType(pokemon.getType());

        return pokemonDto;
    }

    private Pokemon mapToEntity(PokemonDto pokemonDto){
        Pokemon pokemon = new Pokemon();

        pokemon.setName(pokemonDto.getName());
        pokemon.setId(pokemonDto.getId());
        pokemon.setType(pokemonDto.getType());

        return pokemon;
    }

    @Override
    public void deleteAllPokemon() {
        pokemonRepository.deleteAll();
    }
}
