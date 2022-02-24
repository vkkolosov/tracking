package com.example.tracking.repository;

import com.example.tracking.model.Prefix;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PrefixRepositoryTest {

    @Autowired
    PrefixRepository prefixRepository; //в SpringBootTest тоже почему-то работает

    @Test
    void findPrefixByPrefix() {

        Prefix prefix = prefixRepository.findPrefixByPrefix("APMU");
        assertThat(prefix.getId()).isEqualTo(1);

    }
}