package com.example.customquery.specification;

import com.example.customquery.dto.request.LinkedPredicate;
import com.example.customquery.entity.Car;
import com.example.customquery.entity.Desert;
import com.example.customquery.entity.Person;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class PersonSpecification implements Specification<Person> {

    private String value;

    private LinkedPredicate linkedPredicate;

    public PersonSpecification(String value,LinkedPredicate linkedPredicate) {
        this.value = value;
        this.linkedPredicate = linkedPredicate;
    }

    @Override
    public Predicate toPredicate(Root<Person> root,
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {


        Join<Person, Desert> joinPersonDesert = root.join("desert"/*,JoinType.LEFT*/);
        Predicate predicate =
                criteriaBuilder.like(joinPersonDesert.get("name"),"%"+value+"%");
        criteriaQuery.distinct(true);
        //join Car on p.id = car.person_id where car.marka like '%value%'
        return predicate;

//        Predicate predicateByFirstName =
//                criteriaBuilder.like(root.get("firstName"),"%"+value+"%");
//        //where firstName like '%value%'
//
//        Predicate predicateByLastName =
//                criteriaBuilder.like(root.get("lastName"),"%"+value+"%");
//        //where lastName like '%value%'
//
//        if(linkedPredicate == LinkedPredicate.AND){
//            return criteriaBuilder.and(predicateByFirstName,predicateByLastName);
//
//        }else{
//            return criteriaBuilder.or(predicateByFirstName,predicateByLastName);
//        }
//       // where firstName like '%value%' or lastName like '%value%'
    }
}
