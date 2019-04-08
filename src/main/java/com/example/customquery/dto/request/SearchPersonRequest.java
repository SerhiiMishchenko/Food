package com.example.customquery.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class SearchPersonRequest {

    @NotNull
    private String value;

    private LinkedPredicate linkedPredicate;

    private Integer page;

    private Integer size;

    private SortRequest sortRequest;

}
