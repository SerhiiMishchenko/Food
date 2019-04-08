package com.example.customquery.dto.response;

import com.example.customquery.entity.Car;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponse {

    private Long id;

    private String marka;

    private String model;

    private Integer power;

    private String pathToImg;

    public CarResponse(Car car) {
        this.id = car.getId();
        this.marka = car.getMarka();
        this.model = car.getModel();
        this.power = car.getPower();
        this.pathToImg = car.getPathToImg();
    }
}
