package com.example.demo.tacos;

import java.util.List;

import lombok.Data;

@Data
public class Taco {
	
	private  String name;
	private List<String> ingrdients;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getIngrdients() {
		return ingrdients;
	}
	public void setIngrdients(List<String> ingrdients) {
		this.ingrdients = ingrdients;
	}
	
	
	

}
