package com.example.tracking.repository;

import com.example.tracking.model.Prefix;
import org.springframework.data.jpa.repository.JpaRepository;

//модель и тип id
public interface PrefixRepository extends JpaRepository <Prefix, Integer> {

        Prefix findPrefixByPrefix(String prefix);

}
