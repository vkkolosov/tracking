package com.example.tracking;

import com.example.tracking.service.PrefixService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

//второй вариант
import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PrefixServiceTest {

    @Autowired
    private PrefixService prefixService; //работает с полем private final в Service

    @Nested
    @DisplayName("substringtest() is working")
    public class getPrefixFromRequest {

        @ParameterizedTest(name = "return {1} on {0}")
        @CsvSource(value = {"REQ123, REQ1"}) //с двумя параметрами Spring ругается, что порт занят
        public void return_correct_prefix(String request, String result) {
            assertEquals(result, prefixService.getPrefixFromRequest(request));
        }
    }

    //Второй вариант
    @Test
    public void getPrefixFromRequest1() {

        //given
        String input = "APMU5536781";
        String expectedResult = "APMU";

        //run
        String result = prefixService.getPrefixFromRequest(input);

        //assert
        Assert.assertEquals(expectedResult, result);

    }

    /*
    @Test
    public void getIdObjectPrefixFromRequest1() {

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
