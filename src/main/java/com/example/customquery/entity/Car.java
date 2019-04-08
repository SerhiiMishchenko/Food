package com.example.customquery.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String marka;

    private String model;

    private Integer power;

    private String pathToImg;

    @ManyToOne
    private Person person;

    public Car() {
    }

    public Car(String marka, String model, Integer power,String pathToImg) {
        this.marka = marka;
        this.model = model;
        this.power = power;
        this.pathToImg = pathToImg;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", power=" + power +
                '}';
    }
}
