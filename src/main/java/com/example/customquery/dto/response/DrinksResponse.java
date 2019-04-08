package com.example.customquery.dto.response;

import com.example.customquery.entity.Drinks;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrinksResponse {

    private Long id;

    private String name;

    private String description;

    private Double weight;

    private Integer price;


    private String pathToImg;

    public DrinksResponse(Drinks drinks) {
        this.id = drinks.getId();
        this.name = drinks.getName();
        this.description = drinks.getDescription();
        this.weight = drinks.getWeight();
        this.price = drinks.getPrice();
        this.pathToImg = drinks.getPathToImg();

    }
}
