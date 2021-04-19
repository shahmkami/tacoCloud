package com.example.demo.tacos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.tacos.Ingredient.Type;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/design")
	public String showDesignForm(Model model) {
		List<Ingredient> ingredients = Arrays.asList(
				new Ingredient("FLTO","Flour Tortilla",Type.WRAP),
				new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
				 new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
				 new Ingredient("CARN", "Carnitas", Type.PROTEIN),
				 new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
				 new Ingredient("LETC", "Lettuce", Type.VEGGIES),
				 new Ingredient("CHED", "Cheddar", Type.CHEESE),
				 new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
				 new Ingredient("SLSA", "Salsa", Type.SAUCE),
				 new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
				);
		
		Type[] types=Ingredient.Type.values();
		
		for(Type t: types) {
			List<Ingredient> i= filterByType(ingredients, t);
			for(Ingredient ing:i)
				System.out.print(ing.id+","+ing.name+","+ing.type);
		}
		
		for(Type type:types) {
		
			model.addAttribute(type.toString().toLowerCase(),
					filterByType(ingredients,type)
					);
		}
		model.addAttribute("design",new Taco());
		return "design";
	}
	
	@PostMapping("/design")
	public String processDesign(Taco design) {
		
		System.out.println("Processing design:" +design);
		
		return "redirect:/orders/current";
	}
	
//	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
//
//	    return ingredients.stream()
//	            .filter(x -> x.().equals(type))
//	            .collect(Collectors.toList());
//
//	}
	
	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
		List<Ingredient> ing = new ArrayList<>();
		for(Ingredient i:ingredients) {
			if(i.type.equals(type)) {
				ing.add(i);
			}
		}
		return ing;
	}

}
