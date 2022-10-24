package com.spring.msscbrewery.web.bootstrap;

import com.spring.msscbrewery.web.domain.Beer;
import com.spring.msscbrewery.web.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository){
        this.beerRepository=beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count()==0) {
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(33700000001L)
                    .price(new BigDecimal("12.95"))
                    .minOnHand(12)
                    .build());
            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .upc(337000000015L)
                    .price(new BigDecimal("11.95"))
                    .minOnHand(12)
                    .build());
        }
        System.out.println(beerRepository.count());
    }
}
