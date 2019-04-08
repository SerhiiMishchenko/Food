package com.example.customquery.controller;

import com.example.customquery.dto.request.DrinksRequest;
import com.example.customquery.dto.response.DrinksResponse;
import com.example.customquery.service.DrinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/drinks")
public class DrinksController {

    @Autowired
    private DrinksService drinksService;

    @PostMapping
    public void saveDrinks(@RequestBody DrinksRequest drinksRequest)throws IOException {
        drinksService.save(drinksRequest);
    }

    @GetMapping
    public List<DrinksResponse> get(){
        return drinksService.get();
    }
}

