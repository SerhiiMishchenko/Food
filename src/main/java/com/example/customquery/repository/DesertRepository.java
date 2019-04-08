package com.example.customquery.repository;

import com.example.customquery.entity.Desert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesertRepository extends JpaRepository<Desert,Long> {

    List<Desert> findByName (String name);
    List<Desert> findByNameAndPrice (String name, Integer price);

    //List<Desert> findById(Long id);
//    List<Desert> findAllByPrice(Integer price);
//    List<Desert> findAllByWeight(Integer weight);
//    List<Desert> findAllByNameAndPrice(String name, Integer price);
//    List<Desert> findAllByNameAndWeight(String name, Integer weight);

}
