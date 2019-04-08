package com.example.customquery.repository;

import com.example.customquery.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza,Long> {

    List<Pizza> findByName (String name);
    List<Pizza> findByNameAndPrice (String name, Integer price);

    // List<Pizza> findById(Long id);
//    List<Pizza> findAllByName(String name);
//    List<Pizza> findAllByPrice(Integer price);
//    List<Pizza> findAllByWeight(Integer weight);
//    List<Pizza> findAllByNameAndPrice(String name, Integer price);
//    List<Pizza> findAllByNameAndWeight(String name, Integer weight);
}