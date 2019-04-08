package com.example.customquery.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Drinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String description;

    private Double weight;

    private Integer price;

    private Boolean availability;

    private Integer number;

    private String dateOfpProduction;

    private String timeOfProduction;

    private String pathToImg;

    private String maker;

    @ManyToOne
    private Person person;


    public Drinks() {
    }

    public Drinks(String name, String description, Integer price, Double weight) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Drinks{" +
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
