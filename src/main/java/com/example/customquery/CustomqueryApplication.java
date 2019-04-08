package com.example.customquery;

import com.example.customquery.repository.CarRepository;
import com.example.customquery.entity.*;
import com.example.customquery.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CustomqueryApplication {

    @Autowired
    private DesertRepository desertRepository;

    @Autowired
    private DrinksRepository drinksRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private SushiRepository sushiRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CarRepository carRepository;


    public static void main(String[] args) {
        SpringApplication.run(CustomqueryApplication.class, args); }

    @PostConstruct
    public void postMain(){


        Person person = new Person();
        person.setFirstName("Sergiy");
        person.setLastName("Mishchenko");
        person.setLogin("admin");
        person.setPassword("admin");
        person.setRole(Role.ROLE_ADMIN);
        personRepository.save(person);

        Person person1 = new Person();
        person1.setFirstName("Olia");
        person1.setLastName("Duda");
        person1.setLogin("root");
        person1.setPassword("root");
        person1.setRole(Role.ROLE_USER);
        personRepository.save(person1);

        Car car = new Car();
        car.setMarka("bmw");
        car.setModel("345t");
        car.setPower(120);
        carRepository.save(car);

//        Menu menu = new Menu();
//        Menu menu1 = new Menu();
//        Menu menu2 = new Menu();
//        Menu menu3 = new Menu();
//        menu.setName("Desert");
//        menu1.setName("Drinks");
//        menu2.setName("Pizza");
//        menu3.setName("Sushi");
//        menuRepository.save(menu);
//        menuRepository.save(menu1);
//        menuRepository.save(menu2);
//        menuRepository.save(menu3);

        Desert desert = new Desert();
        desert.setName("Гіолетовий фондан");
        desert.setDescription("Популярний десерт французького походження, кекс з шоколадного бісківтного тіста.");
        desert.setPrice(160);
        desert.setWeight(130);
        desert.setAvailability(true);
        desert.setNumber(10);
        desert.setDateOfpProduction("2019-01-01");
        desert.setTimeOfProduction("13:25:45");
        desert.setMaker("Дуда Ольга");
        desert.setPerson(person);
        desertRepository.save(desert);

        Drinks drinks = new Drinks();
        drinks.setName("Пиво Kronenburg blanc");
        drinks.setDescription("Скло/банка");
        drinks.setPrice(29);
        drinks.setWeight(0.45);
        drinks.setAvailability(true);
        drinks.setNumber(10);
        drinks.setDateOfpProduction("2018-12-12");
        drinks.setTimeOfProduction("17:35:35");
        drinks.setMaker("Чернігівське");
        drinks.setPerson(person);
        drinksRepository.save(drinks);

        Pizza pizza = new Pizza();
        pizza.setName("Піцца Гавайська");
        pizza.setDescription("Моцарела помідори куряче філе печене ананас консервований соус червоний");
        pizza.setPrice(149);
        pizza.setWeight(550);
        pizza.setSize(35);
        pizza.setAvailability(true);
        pizza.setNumber(10);
        pizza.setDateOfpProduction("2019-01-01");
        pizza.setTimeOfProduction("13:45:50");
        pizza.setMaker("Сергій Міщенко");
        pizza.setPerson(person);
        pizzaRepository.save(pizza);

        Sushi sushi = new Sushi();
        sushi.setName("Гон-Конг");
        sushi.setDescription("Рис, Норі, Крем-сир, соус Унагі, Огірок, Кунжут білий, Зелена цибуля, Вугор, Лосось свіжий.");
        sushi.setPrice(135);
        sushi.setWeight(220);
        sushi.setAvailability(true);
        sushi.setNumber(10);
        sushi.setDateOfpProduction("2017-12-31");
        sushi.setTimeOfProduction("12:45:31");
        sushi.setMaker("Наталія Дуда");
        sushi.setPerson(person);
        sushiRepository.save(sushi);

        Desert desert1 = new Desert();
        desert1.setName("Гіолетовий фондан");
        desert1.setDescription("Популярний десерт французького походження, кекс з шоколадного бісківтного тіста.");
        desert1.setPrice(160);
        desert1.setWeight(130);
        desert1.setAvailability(true);
        desert1.setNumber(10);
        desert1.setDateOfpProduction("2019-01-01");
        desert1.setTimeOfProduction("13:25:45");
        desert1.setMaker("Дуда Ольга");
        desert1.setPerson(person);
        desertRepository.save(desert1);

        Drinks drinks1 = new Drinks();
        drinks1.setName("Пиво Kronenburg blanc");
        drinks1.setDescription("Скло/банка");
        drinks1.setPrice(29);
        drinks1.setWeight(0.45);
        drinks1.setAvailability(true);
        drinks1.setNumber(10);
        drinks1.setDateOfpProduction("2018-12-12");
        drinks1.setTimeOfProduction("17:35:35");
        drinks1.setMaker("Чернігівське");
        drinks1.setPerson(person);
        drinksRepository.save(drinks1);

        Pizza pizza1 = new Pizza();
        pizza1.setName("Піцца Гавайська");
        pizza1.setDescription("Моцарела помідори куряче філе печене ананас консервований соус червоний");
        pizza1.setPrice(149);
        pizza1.setWeight(550);
        pizza1.setSize(35);
        pizza1.setAvailability(true);
        pizza1.setNumber(10);
        pizza1.setDateOfpProduction("2019-01-01");
        pizza1.setTimeOfProduction("13:45:50");
        pizza1.setMaker("Сергій Міщенко");
        pizza1.setPerson(person);
        pizzaRepository.save(pizza1);

        Sushi sushi1 = new Sushi();
        sushi1.setName("Гон-Конг");
        sushi1.setDescription("Рис, Норі, Крем-сир, соус Унагі, Огірок, Кунжут білий, Зелена цибуля, Вугор, Лосось свіжий.");
        sushi1.setPrice(135);
        sushi1.setWeight(220);
        sushi1.setAvailability(true);
        sushi1.setNumber(10);
        sushi1.setDateOfpProduction("2017-12-31");
        sushi1.setTimeOfProduction("12:45:31");
        sushi1.setMaker("Наталія Дуда");
        sushi1.setPerson(person);
        sushiRepository.save(sushi1);

        Desert desert2 = new Desert();
        desert2.setName("Гіолетовий фондан");
        desert2.setDescription("Популярний десерт французького походження, кекс з шоколадного бісківтного тіста.");
        desert2.setPrice(160);
        desert2.setWeight(130);
        desert2.setAvailability(true);
        desert2.setNumber(10);
        desert2.setDateOfpProduction("2019-01-01");
        desert2.setTimeOfProduction("13:25:45");
        desert2.setMaker("Дуда Ольга");
        desert2.setPerson(person);
        desertRepository.save(desert2);

        Drinks drinks2 = new Drinks();
        drinks2.setName("Пиво Kronenburg blanc");
        drinks2.setDescription("Скло/банка");
        drinks2.setPrice(29);
        drinks2.setWeight(0.45);
        drinks2.setAvailability(true);
        drinks2.setNumber(10);
        drinks2.setDateOfpProduction("2018-12-12");
        drinks2.setTimeOfProduction("17:35:35");
        drinks2.setMaker("Чернігівське");
        drinks2.setPerson(person);
        drinksRepository.save(drinks2);

        Pizza pizza2 = new Pizza();
        pizza2.setName("Піцца Гавайська");
        pizza2.setDescription("Моцарела помідори куряче філе печене ананас консервований соус червоний");
        pizza2.setPrice(149);
        pizza2.setWeight(550);
        pizza2.setSize(35);
        pizza2.setAvailability(true);
        pizza2.setNumber(10);
        pizza2.setDateOfpProduction("2019-01-01");
        pizza2.setTimeOfProduction("13:45:50");
        pizza2.setMaker("Сергій Міщенко");
        pizza2.setPerson(person);
        pizzaRepository.save(pizza2);

        Sushi sushi2 = new Sushi();
        sushi2.setName("Гон-Конг");
        sushi2.setDescription("Рис, Норі, Крем-сир, соус Унагі, Огірок, Кунжут білий, Зелена цибуля, Вугор, Лосось свіжий.");
        sushi2.setPrice(135);
        sushi2.setWeight(220);
        sushi2.setAvailability(true);
        sushi2.setNumber(10);
        sushi2.setDateOfpProduction("2017-12-31");
        sushi2.setTimeOfProduction("12:45:31");
        sushi2.setMaker("Наталія Дуда");
        sushi2.setPerson(person);
        sushiRepository.save(sushi2);

        Desert desert3 = new Desert();
        desert3.setName("Гіолетовий фондан");
        desert3.setDescription("Популярний десерт французького походження, кекс з шоколадного бісківтного тіста.");
        desert3.setPrice(160);
        desert3.setWeight(130);
        desert3.setAvailability(true);
        desert3.setNumber(10);
        desert3.setDateOfpProduction("2019-01-01");
        desert3.setTimeOfProduction("13:25:45");
        desert3.setMaker("Дуда Ольга");
        desert3.setPerson(person);
        desertRepository.save(desert3);

        Drinks drinks3 = new Drinks();
        drinks3.setName("Пиво Kronenburg blanc");
        drinks3.setDescription("Скло/банка");
        drinks3.setPrice(29);
        drinks3.setWeight(0.45);
        drinks3.setAvailability(true);
        drinks3.setNumber(10);
        drinks3.setDateOfpProduction("2018-12-12");
        drinks3.setTimeOfProduction("17:35:35");
        drinks3.setMaker("Чернігівське");
        drinks3.setPerson(person);
        drinksRepository.save(drinks3);

        Pizza pizza3 = new Pizza();
        pizza3.setName("Піцца Гавайська");
        pizza3.setDescription("Моцарела помідори куряче філе печене ананас консервований соус червоний");
        pizza3.setPrice(149);
        pizza3.setWeight(550);
        pizza3.setSize(35);
        pizza3.setAvailability(true);
        pizza3.setNumber(10);
        pizza3.setDateOfpProduction("2019-01-01");
        pizza3.setTimeOfProduction("13:45:50");
        pizza3.setMaker("Сергій Міщенко");
        pizza3.setPerson(person);
        pizzaRepository.save(pizza3);

        Sushi sushi3 = new Sushi();
        sushi3.setName("Гон-Конг");
        sushi3.setDescription("Рис, Норі, Крем-сир, соус Унагі, Огірок, Кунжут білий, Зелена цибуля, Вугор, Лосось свіжий.");
        sushi3.setPrice(135);
        sushi3.setWeight(220);
        sushi3.setAvailability(true);
        sushi3.setNumber(10);
        sushi3.setDateOfpProduction("2017-12-31");
        sushi3.setTimeOfProduction("12:45:31");
        sushi3.setMaker("Наталія Дуда");
        sushi3.setPerson(person);
        sushiRepository.save(sushi3);

        Desert desert4 = new Desert();
        desert4.setName("Гіолетовий фондан");
        desert4.setDescription("Популярний десерт французького походження, кекс з шоколадного бісківтного тіста.");
        desert4.setPrice(160);
        desert4.setWeight(130);
        desert4.setAvailability(true);
        desert4.setNumber(10);
        desert4.setDateOfpProduction("2019-01-01");
        desert4.setTimeOfProduction("13:25:45");
        desert4.setMaker("Дуда Ольга");
        desert4.setPerson(person);
        desertRepository.save(desert4);

        Drinks drinks4 = new Drinks();
        drinks4.setName("Пиво Kronenburg blanc");
        drinks4.setDescription("Скло/банка");
        drinks4.setPrice(29);
        drinks4.setWeight(0.45);
        drinks4.setAvailability(true);
        drinks4.setNumber(10);
        drinks4.setDateOfpProduction("2018-12-12");
        drinks4.setTimeOfProduction("17:35:35");
        drinks4.setMaker("Чернігівське");
        drinks4.setPerson(person);
        drinksRepository.save(drinks4);

        Pizza pizza4 = new Pizza();
        pizza4.setName("Піцца Гавайська");
        pizza4.setDescription("Моцарела помідори куряче філе печене ананас консервований соус червоний");
        pizza4.setPrice(149);
        pizza4.setWeight(550);
        pizza4.setSize(35);
        pizza4.setAvailability(true);
        pizza4.setNumber(10);
        pizza4.setDateOfpProduction("2019-01-01");
        pizza4.setTimeOfProduction("13:45:50");
        pizza4.setMaker("Сергій Міщенко");
        pizza4.setPerson(person);
        pizzaRepository.save(pizza4);

        Sushi sushi4 = new Sushi();
        sushi4.setName("Гон-Конг");
        sushi4.setDescription("Рис, Норі, Крем-сир, соус Унагі, Огірок, Кунжут білий, Зелена цибуля, Вугор, Лосось свіжий.");
        sushi4.setPrice(135);
        sushi4.setWeight(220);
        sushi4.setAvailability(true);
        sushi4.setNumber(10);
        sushi4.setDateOfpProduction("2017-12-31");
        sushi4.setTimeOfProduction("12:45:31");
        sushi4.setMaker("Наталія Дуда");
        sushi4.setPerson(person);
        sushiRepository.save(sushi4);

        Desert desert5 = new Desert();
        desert5.setName("Гіолетовий фондан");
        desert5.setDescription("Популярний десерт французького походження, кекс з шоколадного бісківтного тіста.");
        desert5.setPrice(160);
        desert5.setWeight(130);
        desert5.setAvailability(true);
        desert5.setNumber(10);
        desert5.setDateOfpProduction("2019-01-01");
        desert5.setTimeOfProduction("13:25:45");
        desert5.setMaker("Дуда Ольга");
        desert5.setPerson(person);
        desertRepository.save(desert5);

        Drinks drinks5 = new Drinks();
        drinks5.setName("Пиво Kronenburg blanc");
        drinks5.setDescription("Скло/банка");
        drinks5.setPrice(29);
        drinks5.setWeight(0.45);
        drinks5.setAvailability(true);
        drinks5.setNumber(10);
        drinks5.setDateOfpProduction("2018-12-12");
        drinks5.setTimeOfProduction("17:35:35");
        drinks5.setMaker("Чернігівське");
        drinks5.setPerson(person);
        drinksRepository.save(drinks5);

        Pizza pizza5 = new Pizza();
        pizza5.setName("Піцца Гавайська");
        pizza5.setDescription("Моцарела помідори куряче філе печене ананас консервований соус червоний");
        pizza5.setPrice(149);
        pizza5.setWeight(550);
        pizza5.setSize(35);
        pizza5.setAvailability(true);
        pizza5.setNumber(10);
        pizza5.setDateOfpProduction("2019-01-01");
        pizza5.setTimeOfProduction("13:45:50");
        pizza5.setMaker("Сергій Міщенко");
        pizza5.setPerson(person);
        pizzaRepository.save(pizza5);

        Sushi sushi5 = new Sushi();
        sushi5.setName("Гон-Конг");
        sushi5.setDescription("Рис, Норі, Крем-сир, соус Унагі, Огірок, Кунжут білий, Зелена цибуля, Вугор, Лосось свіжий.");
        sushi5.setPrice(135);
        sushi5.setWeight(220);
        sushi5.setAvailability(true);
        sushi5.setNumber(10);
        sushi5.setDateOfpProduction("2017-12-31");
        sushi5.setTimeOfProduction("12:45:31");
        sushi5.setMaker("Наталія Дуда");
        sushi5.setPerson(person);
        sushiRepository.save(sushi5);

        Desert desert6 = new Desert();
        desert6.setName("Гіолетовий фондан");
        desert6.setDescription("Популярний десерт французького походження, кекс з шоколадного бісківтного тіста.");
        desert6.setPrice(160);
        desert6.setWeight(130);
        desert6.setAvailability(true);
        desert6.setNumber(10);
        desert6.setDateOfpProduction("2019-01-01");
        desert6.setTimeOfProduction("13:25:45");
        desert6.setMaker("Дуда Ольга");
        desert6.setPerson(person);
        desertRepository.save(desert6);

        Drinks drinks6 = new Drinks();
        drinks6.setName("Пиво Kronenburg blanc");
        drinks6.setDescription("Скло/банка");
        drinks6.setPrice(29);
        drinks6.setWeight(0.45);
        drinks6.setAvailability(true);
        drinks6.setNumber(10);
        drinks6.setDateOfpProduction("2018-12-12");
        drinks6.setTimeOfProduction("17:35:35");
        drinks6.setMaker("Чернігівське");
        drinks6.setPerson(person);
        drinksRepository.save(drinks6);

        Pizza pizza6 = new Pizza();
        pizza6.setName("Піцца Гавайська");
        pizza6.setDescription("Моцарела помідори куряче філе печене ананас консервований соус червоний");
        pizza6.setPrice(149);
        pizza6.setWeight(550);
        pizza6.setSize(35);
        pizza6.setAvailability(true);
        pizza6.setNumber(10);
        pizza6.setDateOfpProduction("2019-01-01");
        pizza6.setTimeOfProduction("13:45:50");
        pizza6.setMaker("Сергій Міщенко");
        pizza6.setPerson(person);
        pizzaRepository.save(pizza6);

        Sushi sushi6 = new Sushi();
        sushi6.setName("Гон-Конг");
        sushi6.setDescription("Рис, Норі, Крем-сир, соус Унагі, Огірок, Кунжут білий, Зелена цибуля, Вугор, Лосось свіжий.");
        sushi6.setPrice(135);
        sushi6.setWeight(220);
        sushi6.setAvailability(true);
        sushi6.setNumber(10);
        sushi6.setDateOfpProduction("2017-12-31");
        sushi6.setTimeOfProduction("12:45:31");
        sushi6.setMaker("Наталія Дуда");
        sushi6.setPerson(person);
        sushiRepository.save(sushi6);

        Desert desert7 = new Desert();
        desert7.setName("Гіолетовий фондан");
        desert7.setDescription("Популярний десерт французького походження, кекс з шоколадного бісківтного тіста.");
        desert7.setPrice(160);
        desert7.setWeight(130);
        desert7.setAvailability(true);
        desert7.setNumber(10);
        desert7.setDateOfpProduction("2019-01-01");
        desert7.setTimeOfProduction("13:25:45");
        desert7.setMaker("Дуда Ольга");
        desert7.setPerson(person);
        desertRepository.save(desert7);

        Drinks drinks7 = new Drinks();
        drinks7.setName("Пиво Kronenburg blanc");
        drinks7.setDescription("Скло/банка");
        drinks7.setPrice(29);
        drinks7.setWeight(0.45);
        drinks7.setAvailability(true);
        drinks7.setNumber(10);
        drinks7.setDateOfpProduction("2018-12-12");
        drinks7.setTimeOfProduction("17:35:35");
        drinks7.setMaker("Чернігівське");
        drinks7.setPerson(person);
        drinksRepository.save(drinks7);

        Pizza pizza7 = new Pizza();
        pizza7.setName("Піцца Гавайська");
        pizza7.setDescription("Моцарела помідори куряче філе печене ананас консервований соус червоний");
        pizza7.setPrice(149);
        pizza7.setWeight(550);
        pizza7.setSize(35);
        pizza7.setAvailability(true);
        pizza7.setNumber(10);
        pizza7.setDateOfpProduction("2019-01-01");
        pizza7.setTimeOfProduction("13:45:50");
        pizza7.setMaker("Сергій Міщенко");
        pizza7.setPerson(person);
        pizzaRepository.save(pizza7);

        Sushi sushi7 = new Sushi();
        sushi7.setName("Гон-Конг");
        sushi7.setDescription("Рис, Норі, Крем-сир, соус Унагі, Огірок, Кунжут білий, Зелена цибуля, Вугор, Лосось свіжий.");
        sushi7.setPrice(135);
        sushi7.setWeight(220);
        sushi7.setAvailability(true);
        sushi7.setNumber(10);
        sushi7.setDateOfpProduction("2017-12-31");
        sushi7.setTimeOfProduction("12:45:31");
        sushi7.setMaker("Наталія Дуда");
        sushi7.setPerson(person);
        sushiRepository.save(sushi7);

        Desert desert8 = new Desert();
        desert8.setName("Гіолетовий фондан");
        desert8.setDescription("Популярний десерт французького походження, кекс з шоколадного бісківтного тіста.");
        desert8.setPrice(160);
        desert8.setWeight(130);
        desert8.setAvailability(true);
        desert8.setNumber(10);
        desert8.setDateOfpProduction("2019-01-01");
        desert8.setTimeOfProduction("13:25:45");
        desert8.setMaker("Дуда Ольга");
        desert8.setPerson(person);
        desertRepository.save(desert8);

        Drinks drinks8 = new Drinks();
        drinks8.setName("Пиво Kronenburg blanc");
        drinks8.setDescription("Скло/банка");
        drinks8.setPrice(29);
        drinks8.setWeight(0.45);
        drinks8.setAvailability(true);
        drinks8.setNumber(10);
        drinks8.setDateOfpProduction("2018-12-12");
        drinks8.setTimeOfProduction("17:35:35");
        drinks8.setMaker("Чернігівське");
        drinks8.setPerson(person);
        drinksRepository.save(drinks8);

        Pizza pizza8 = new Pizza();
        pizza8.setName("Піцца Гавайська");
        pizza8.setDescription("Моцарела помідори куряче філе печене ананас консервований соус червоний");
        pizza8.setPrice(149);
        pizza8.setWeight(550);
        pizza8.setSize(35);
        pizza8.setAvailability(true);
        pizza8.setNumber(10);
        pizza8.setDateOfpProduction("2019-01-01");
        pizza8.setTimeOfProduction("13:45:50");
        pizza8.setMaker("Сергій Міщенко");
        pizza8.setPerson(person);
        pizzaRepository.save(pizza8);

        Sushi sushi8 = new Sushi();
        sushi8.setName("Гон-Конг");
        sushi8.setDescription("Рис, Норі, Крем-сир, соус Унагі, Огірок, Кунжут білий, Зелена цибуля, Вугор, Лосось свіжий.");
        sushi8.setPrice(135);
        sushi8.setWeight(220);
        sushi8.setAvailability(true);
        sushi8.setNumber(10);
        sushi8.setDateOfpProduction("2017-12-31");
        sushi8.setTimeOfProduction("12:45:31");
        sushi8.setMaker("Наталія Дуда");
        sushi8.setPerson(person);
        sushiRepository.save(sushi8);

        Desert desert9 = new Desert();
        desert9.setName("Гіолетовий фондан");
        desert9.setDescription("Популярний десерт французького походження, кекс з шоколадного бісківтного тіста.");
        desert9.setPrice(160);
        desert9.setWeight(130);
        desert9.setAvailability(true);
        desert9.setNumber(10);
        desert9.setDateOfpProduction("2019-01-01");
        desert9.setTimeOfProduction("13:25:45");
        desert9.setMaker("Дуда Ольга");
        desert9.setPerson(person);
        desertRepository.save(desert9);

        Drinks drinks9 = new Drinks();
        drinks9.setName("Пиво Kronenburg blanc");
        drinks9.setDescription("Скло/банка");
        drinks9.setPrice(29);
        drinks9.setWeight(0.45);
        drinks9.setAvailability(true);
        drinks9.setNumber(10);
        drinks9.setDateOfpProduction("2018-12-12");
        drinks9.setTimeOfProduction("17:35:35");
        drinks9.setMaker("Чернігівське");
        drinks9.setPerson(person);
        drinksRepository.save(drinks9);

        Pizza pizza9 = new Pizza();
        pizza9.setName("Піцца Гавайська");
        pizza9.setDescription("Моцарела помідори куряче філе печене ананас консервований соус червоний");
        pizza9.setPrice(149);
        pizza9.setWeight(550);
        pizza9.setSize(35);
        pizza9.setAvailability(true);
        pizza9.setNumber(10);
        pizza9.setDateOfpProduction("2019-01-01");
        pizza9.setTimeOfProduction("13:45:50");
        pizza9.setMaker("Сергій Міщенко");
        pizza9.setPerson(person);
        pizzaRepository.save(pizza9);

        Sushi sushi9 = new Sushi();
        sushi9.setName("Гон-Конг");
        sushi9.setDescription("Рис, Норі, Крем-сир, соус Унагі, Огірок, Кунжут білий, Зелена цибуля, Вугор, Лосось свіжий.");
        sushi9.setPrice(135);
        sushi9.setWeight(220);
        sushi9.setAvailability(true);
        sushi9.setNumber(10);
        sushi9.setDateOfpProduction("2017-12-31");
        sushi9.setTimeOfProduction("12:45:31");
        sushi9.setMaker("Наталія Дуда");
        sushi9.setPerson(person);
        sushiRepository.save(sushi9);

        Desert desert10 = new Desert();
        desert10.setName("Гіолетовий фондан");
        desert10.setDescription("Популярний десерт французького походження, кекс з шоколадного бісківтного тіста.");
        desert10.setPrice(160);
        desert10.setWeight(130);
        desert10.setAvailability(true);
        desert10.setNumber(10);
        desert10.setDateOfpProduction("2019-01-01");
        desert10.setTimeOfProduction("13:25:45");
        desert10.setMaker("Дуда Ольга");
        desert10.setPerson(person);
        desertRepository.save(desert10);

        Drinks drinks10 = new Drinks();
        drinks10.setName("Пиво Kronenburg blanc");
        drinks10.setDescription("Скло/банка");
        drinks10.setPrice(29);
        drinks10.setWeight(0.45);
        drinks10.setAvailability(true);
        drinks10.setNumber(10);
        drinks10.setDateOfpProduction("2018-12-12");
        drinks10.setTimeOfProduction("17:35:35");
        drinks10.setMaker("Чернігівське");
        drinks10.setPerson(person);
        drinksRepository.save(drinks10);

        Pizza pizza10 = new Pizza();
        pizza10.setName("Піцца Гавайська");
        pizza10.setDescription("Моцарела помідори куряче філе печене ананас консервований соус червоний");
        pizza10.setPrice(149);
        pizza10.setWeight(550);
        pizza10.setSize(35);
        pizza10.setAvailability(true);
        pizza10.setNumber(10);
        pizza10.setDateOfpProduction("2019-01-01");
        pizza10.setTimeOfProduction("13:45:50");
        pizza10.setMaker("Сергій Міщенко");
        pizza10.setPerson(person);
        pizzaRepository.save(pizza10);

        Sushi sushi10 = new Sushi();
        sushi10.setName("Гон-Конг");
        sushi10.setDescription("Рис, Норі, Крем-сир, соус Унагі, Огірок, Кунжут білий, Зелена цибуля, Вугор, Лосось свіжий.");
        sushi10.setPrice(135);
        sushi10.setWeight(220);
        sushi10.setAvailability(true);
        sushi10.setNumber(10);
        sushi10.setDateOfpProduction("2017-12-31");
        sushi10.setTimeOfProduction("12:45:31");
        sushi10.setMaker("Наталія Дуда");
        sushi10.setPerson(person);
        sushiRepository.save(sushi10);

        Desert desert11 = new Desert();
        desert11.setName("Гіолетовий фондан");
        desert11.setDescription("Популярний десерт французького походження, кекс з шоколадного бісківтного тіста.");
        desert11.setPrice(160);
        desert11.setWeight(130);
        desert11.setAvailability(true);
        desert11.setNumber(10);
        desert11.setDateOfpProduction("2019-01-01");
        desert11.setTimeOfProduction("13:25:45");
        desert11.setMaker("Дуда Ольга");
        desert11.setPerson(person);
        desertRepository.save(desert11);

        Drinks drinks11 = new Drinks();
        drinks11.setName("Пиво Kronenburg blanc");
        drinks11.setDescription("Скло/банка");
        drinks11.setPrice(29);
        drinks11.setWeight(0.45);
        drinks11.setAvailability(true);
        drinks11.setNumber(10);
        drinks11.setDateOfpProduction("2018-12-12");
        drinks11.setTimeOfProduction("17:35:35");
        drinks11.setMaker("Чернігівське");
        drinks11.setPerson(person);
        drinksRepository.save(drinks11);

        Pizza pizza11 = new Pizza();
        pizza11.setName("Піцца Гавайська");
        pizza11.setDescription("Моцарела помідори куряче філе печене ананас консервований соус червоний");
        pizza11.setPrice(149);
        pizza11.setWeight(550);
        pizza11.setSize(35);
        pizza11.setAvailability(true);
        pizza11.setNumber(10);
        pizza11.setDateOfpProduction("2019-01-01");
        pizza11.setTimeOfProduction("13:45:50");
        pizza11.setMaker("Сергій Міщенко");
        pizza11.setPerson(person);
        pizzaRepository.save(pizza11);

        Sushi sushi11 = new Sushi();
        sushi11.setName("Гон-Конг");
        sushi11.setDescription("Рис, Норі, Крем-сир, соус Унагі, Огірок, Кунжут білий, Зелена цибуля, Вугор, Лосось свіжий.");
        sushi11.setPrice(135);
        sushi11.setWeight(220);
        sushi11.setAvailability(true);
        sushi11.setNumber(10);
        sushi11.setDateOfpProduction("2017-12-31");
        sushi11.setTimeOfProduction("12:45:31");
        sushi11.setMaker("Наталія Дуда");
        sushi11.setPerson(person);
        sushiRepository.save(sushi11);
    }
}