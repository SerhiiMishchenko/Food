package com.example.customquery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "person")
    private List<Car> cars = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "person")
    private List<Desert> deserts = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "person")
    private List<Drinks> drinks = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "person")
    private List<Pizza> pizzas = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "person")
    private List<Sushi> sushi = new ArrayList<>();


}
