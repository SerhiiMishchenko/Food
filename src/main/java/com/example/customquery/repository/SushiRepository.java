package com.example.customquery.repository;

import com.example.customquery.entity.Sushi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SushiRepository extends JpaRepository<Sushi,Long> {

    List<Sushi> findByName (String name);
    List<Sushi> findByNameAndPrice (String name, Integer price);

    //List<Sushi> findById(Long id);
//    List<Sushi> findAllByName(String name);
//    List<Sushi> findAllByPrice(Integer price);
//    List<Sushi> findAllByWeight(Integer weight);
//    List<Sushi> findAllByNameAndPrice(String name, Integer price);
//    List<Sushi> findAllByNameAndWeight(String name, Integer weight);

}