package com.example.tracking.service;

import com.example.tracking.TrackingApplication;
import com.example.tracking.repository.PrefixRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class PrefixServiceTestIDEA {

    ConfigurableApplicationContext context = SpringApplication.run(TrackingApplication.class);
    PrefixRepository prefixRepository = context.getBean(PrefixRepository.class);

    private final PrefixService prefixService = new PrefixService(prefixRepository); //и все равно так :(

    @Test
    void getPrefixFromRequest() {
    }

    /*
    @Test
    void getIdObjectPrefixFromRequest() {

        //given
        String input = "APMU5536781";
        Integer expectedResult = 1;

        //run
        Integer result = prefixService.getIdObjectPrefixFromRequest(input);

        //assert
        Assert.assertEquals(expectedResult, result);

    }
    */

}