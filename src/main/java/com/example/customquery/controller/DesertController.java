package com.example.customquery.controller;

import com.example.customquery.dto.request.DesertRequest;
import com.example.customquery.dto.response.DesertResponse;
import com.example.customquery.service.DesertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/desert")
public class DesertController {

    @Autowired
    private DesertService desertService;

    @PostMapping
    public void saveDesert(@RequestBody DesertRequest desertRequest)throws IOException {
        desertService.save(desertRequest);
    }

    @GetMapping
    public List<DesertResponse> get(){
        return desertService.get();
    }
}
