package com.example.customquery.controller;

import com.example.customquery.dto.request.CarRequest;
import com.example.customquery.dto.response.CarResponse;
import com.example.customquery.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/car")
public class CarController {


    @Autowired
    private CarService carService;

    @PostMapping
    public void saveCar(@RequestBody CarRequest carRequest) throws IOException {
        carService.save(carRequest);
    }

    @GetMapping
    public List<CarResponse> get(){
        return carService.get();
    }
}

