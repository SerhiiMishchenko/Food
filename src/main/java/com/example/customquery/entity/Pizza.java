package com.example.customquery.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String description;

    private Integer weight;

    private Integer size;

    private Integer price;

    private Boolean availability;

    private Integer number;

    private String dateOfpProduction;

    private String timeOfProduction;

    private String pathToImg;

    private String maker;

    @ManyToOne
    private Person person;

    public Pizza() { }

    public Pizza(String name, String description, Integer price, Integer weight, Integer size) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", availability=" + availability +
                ", dateOfpProduction=" + dateOfpProduction +
                ", timeOfProduction=" + timeOfProduction +
                ", maker='" + maker + '\'' +
                '}';
    }
}
