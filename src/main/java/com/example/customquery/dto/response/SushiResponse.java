package com.example.customquery.dto.response;

import com.example.customquery.entity.Sushi;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SushiResponse {

    private Long id;

    private String name;

    private String description;

    private Integer weight;

    private Integer price;

    private String pathToImg;


    public SushiResponse(Sushi sushi) {
        this.id = sushi.getId();
        this.name = sushi.getName();
        this.description = sushi.getDescription();
        this.weight = sushi.getWeight();
        this.price = sushi.getPrice();
        this.pathToImg = sushi.getPathToImg();

    }
}