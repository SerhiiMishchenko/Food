package com.example.customquery.dto.response;

import com.example.customquery.entity.Desert;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DesertResponse {

    private Long id;

    private String name;

    private String description;

    private Integer weight;

    private Integer price;

    private String pathToImg;

    public DesertResponse(Desert desert) {
        this.id = desert.getId();
        this.name = desert.getName();
        this.description = desert.getDescription();
        this.weight = desert.getWeight();
        this.price = desert.getPrice();
        this.pathToImg = desert.getPathToImg();

    }
}
