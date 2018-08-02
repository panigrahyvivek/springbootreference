package com.vivek.springbootreference.models;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Greeting extends ResourceSupport{

    //private final long id;
    private final String content;

    public Greeting(String content) {
        //this.id = id;
        this.content = content;
    }

    /*public long getId() {
        return id;
    }*/

    public String getContent() {
        return content;
    }
}