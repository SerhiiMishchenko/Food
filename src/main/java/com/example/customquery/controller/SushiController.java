package com.example.customquery.controller;

import com.example.customquery.dto.request.SushiRequest;
import com.example.customquery.dto.response.SushiResponse;
import com.example.customquery.service.SushiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/sushi")
public class SushiController {

    @Autowired
    private SushiService sushiService;

    @PostMapping
    public void saveSushi(@RequestBody SushiRequest sushiRequest)throws IOException {
        sushiService.save(sushiRequest);
    }

    @GetMapping
    public List<SushiResponse> get(){
        return sushiService.get();
    }
}