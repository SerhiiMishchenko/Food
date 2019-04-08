package com.example.customquery.repository;

import com.example.customquery.entity.Drinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinksRepository extends JpaRepository<Drinks,Long> {

    List<Drinks> findByName (String name);
    List<Drinks> findByNameAndPrice (String name, Integer price);

    // List<Drinks> findById(Long id);
//    List<Drinks> findAllByPrice(Integer price);
//    List<Drinks> findAllByWeight(Double weight);
//    List<Drinks> findAllByNameAndPrice(String name, Integer price);
//    List<Drinks> findAllByNameAndWeight(String name, Double weight);

}
