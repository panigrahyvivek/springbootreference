package com.vivek.springbootreference.models;

import java.util.function.IntPredicate;

import org.springframework.boot.jackson.JsonComponent;

//import org.springframework.hateoas.Link;
//import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

//public class Greeting extends ResourceSupport{
public class Greeting{
    //private final long id;

	private String content;

    public Greeting(String content) {
        //this.id = id;
        this.content = content;
    }

	public String getContent() {
		// TODO Auto-generated method stub
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
    
}