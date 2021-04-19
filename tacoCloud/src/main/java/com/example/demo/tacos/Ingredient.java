package com.example.demo.tacos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {

	

	public final String id;
	public final String name ;
	public final Type type ;
	
	public Ingredient(String id, String name, Type type) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.type=type;
	}
	
	public static enum Type{
		WRAP,PROTEIN,VEGGIES,CHEESE,SAUCE
	}



}
