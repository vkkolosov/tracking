package com.example.tracking.repository;

import com.example.tracking.model.LineURL;
import org.springframework.data.jpa.repository.JpaRepository;

//модель и тип id
public interface URLrepository extends JpaRepository <LineURL, String> {

}
