package com.example.customquery.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrinksRequest {

    private String name;

    private String description;

    private Double weight;

    private Integer price;

    private String img;
}
