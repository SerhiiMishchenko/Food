package com.example.customquery.dto.response;

import com.example.customquery.entity.Pizza;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaResponse {

    private Long id;

    private String name;

    private String description;

    private Integer weight;

    private Integer size;

    private Integer price;

    private String pathToImg;

    public PizzaResponse(Pizza pizza) {
        this.id = pizza.getId();
        this.name = pizza.getName();
        this.description = pizza.getDescription();
        this.weight = pizza.getWeight();
        this.size = pizza.getSize();
        this.price = pizza.getPrice();
        this.pathToImg = pizza.getPathToImg();

    }
}
