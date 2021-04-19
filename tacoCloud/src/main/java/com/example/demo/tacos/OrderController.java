package com.example.demo.tacos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {
	
	@GetMapping("/current")
	public String orderForm(Model model) {
		
		model.addAttribute("order",new Order());
		
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(Order order) {
		System.out.println("ORDER"+order.getName()+","+order.getCity()+","+order.getStreet()+","+order.getState()+","+order.getZip());
		return "success";
	}
	
	
	
}
