package com.example.customquery.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SushiRequest {

    private String name;

    private String description;

    private Integer weight;

    private Integer price;

    private String img;
}
