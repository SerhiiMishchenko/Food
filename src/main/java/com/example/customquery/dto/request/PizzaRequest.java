package com.example.customquery.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaRequest {

    private String name;

    private String description;

    private Integer weight;

    private Integer size;

    private Integer price;

    private String img;
}
