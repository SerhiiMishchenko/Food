package com.example.customquery.repository;

import com.example.customquery.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>, JpaSpecificationExecutor<Person> {

    Person findByFirstNameAndLastName(String firstName,String lastName);

    List<Person> findByDesertsName(String name);

    List<Person> findByDrinksName (String name);

    List<Person> findByPizzasName (String name);

    List<Person> findBySushiName (String name);

    List<Person> findByCarsMarka(String marka);

    @Query("select p from Person p join p.cars c where c.marka=:marka")
    List<Person> findByMarkaAuto(@Param("marka") String marka);

    @Query("select p from Person p join p.deserts c where c.name=:name")
    List<Person> findByNameDeserts(@Param("name") String name);

    @Query("select p from Person p join p.drinks c where c.name=:name")
    List<Person> findByNameDrinks(@Param("name") String name);

    @Query("select p from Person p join p.pizzas c where c.name=:name")
    List<Person> findByNamePizzas(@Param("name") String name);

    @Query("select p from Person p join p.sushi c where c.name=:name")
    List<Person> findByNameSushis(@Param("name") String name);

    Person findByLogin(String login);
}
