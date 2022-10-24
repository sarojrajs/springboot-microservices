package com.spring.msscbrewery.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.msscbrewery.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById(){
        try {
            mockMvc.perform(get("/api/v1/beer/"+ UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void saveNewBeer(){
        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoJson = null;
        try {
            beerDtoJson = objectMapper.writeValueAsString(beerDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        try {
            mockMvc.perform(post("/api/v1/beer/").contentType(MediaType.APPLICATION_JSON).content(beerDtoJson)).andExpect(status().isCreated());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void updateBeerById(){
        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoJson = null;
        try {
            beerDtoJson = objectMapper.writeValueAsString(beerDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        try {
            mockMvc.perform(put("/api/v1/beer/"+UUID.randomUUID().toString()).contentType(MediaType.APPLICATION_JSON).content(beerDtoJson)).andExpect(status().isNoContent());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}