package com.example.customquery.service;

import com.example.customquery.dto.DataResponse;
import com.example.customquery.dto.request.PersonRequest;
import com.example.customquery.dto.request.SearchPersonRequest;
import com.example.customquery.dto.request.SortRequest;
import com.example.customquery.dto.response.PersonResponse;
import com.example.customquery.entity.Person;
import com.example.customquery.repository.PersonRepository;
import com.example.customquery.specification.PersonSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public DataResponse<PersonResponse> findAll(SearchPersonRequest searchPersonRequest){
        SortRequest sortRequest = searchPersonRequest.getSortRequest();
        Sort sort = Sort.by(sortRequest.getDirection(), sortRequest.getFieldName());
        PageRequest pageRequest = PageRequest.of(searchPersonRequest.getPage(),searchPersonRequest.getSize(),sort);
        PersonSpecification personSpecification = new PersonSpecification(searchPersonRequest.getValue(),searchPersonRequest.getLinkedPredicate());
        Page<Person> personPage = personRepository.findAll(personSpecification,pageRequest);
        return new DataResponse<PersonResponse>(personPage.getContent().stream().map(PersonResponse::new).collect(Collectors.toList()), personPage);
    }

    public void save(PersonRequest personRequest){
        Person person = new Person();
        person.setFirstName(personRequest.getFirstName());
        person.setLastName(personRequest.getLastName());
        Person personFromDB =personRepository.findByFirstNameAndLastName(person.getFirstName(),person.getLastName());
        if(personFromDB == null){
            personRepository.save(person);
        }else{
            throw new IllegalArgumentException("Person with name "+ person.getFirstName()+" exists");
        }
    }


}
