package com.example.customquery.dto.response;

import com.example.customquery.entity.*;
import lombok.Getter;
import lombok.Setter;
import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private List<DesertResponse> deserts = new ArrayList<>();

    private List<DrinksResponse> drinkss = new ArrayList<>();

    private List<PizzaResponse> pizzas = new ArrayList<>();

    private List<SushiResponse> sushis = new ArrayList<>();



    public PersonResponse(Person person){
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        for (Desert desert: person.getDeserts()) {
            deserts.add(new DesertResponse(desert));
        }
        for (Drinks drinks: person.getDrinks()){
            drinkss.add(new DrinksResponse(drinks));
        }
        for (Pizza pizza: person.getPizzas()){
            pizzas.add(new PizzaResponse(pizza));
        }
        for(Sushi sushi: person.getSushi()){
            sushis.add(new SushiResponse(sushi));

        }
    }

}
