package com.example.customquery.controller;

import com.example.customquery.dto.DataResponse;
import com.example.customquery.dto.request.PersonRequest;
import com.example.customquery.dto.request.SearchPersonRequest;
import com.example.customquery.dto.request.SortRequest;
import com.example.customquery.dto.response.PersonResponse;
import com.example.customquery.entity.Person;
import com.example.customquery.repository.PersonRepository;
import com.example.customquery.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin//крос доменні запити
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/all")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public DataResponse<PersonResponse> findAllPerson(@RequestBody @Valid SearchPersonRequest searchPersonRequest){
        return personService.findAll(searchPersonRequest);
    }

    @PostMapping("/save")
    public void save(@RequestBody PersonRequest personRequest){
        personService.save(personRequest);
    }
}