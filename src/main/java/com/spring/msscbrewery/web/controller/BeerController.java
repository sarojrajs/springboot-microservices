package com.spring.msscbrewery.web.controller;

import com.spring.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/beer")
@RestController
public class BeerController {

    @GetMapping(path = "/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable(value = "beerId") UUID beerId){
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto){
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(path = "/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable(value = "beerId") UUID beerId, @RequestBody BeerDto beerDto){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
