package com.example.customquery.controller;

import com.example.customquery.dto.request.PizzaRequest;
import com.example.customquery.dto.response.PizzaResponse;
import com.example.customquery.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping
    public void savePizza(@RequestBody PizzaRequest pizzaRequest)throws IOException {
        pizzaService.save(pizzaRequest);
    }

    @GetMapping
    public List<PizzaResponse> get(){
        return pizzaService.get();
    }
}
