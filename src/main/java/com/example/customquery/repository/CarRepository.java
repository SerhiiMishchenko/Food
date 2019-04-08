package com.example.customquery.repository;

import com.example.customquery.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByMarka(String marka);

    List<Car> findByMarkaAndModel(String marka, String model);
}
