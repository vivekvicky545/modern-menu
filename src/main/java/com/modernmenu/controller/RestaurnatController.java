package com.modernmenu.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.modernmenu.entity.Restaurant;
import com.modernmenu.service.RestaurantService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/restaurnat")
@CrossOrigin
@AllArgsConstructor
public class RestaurnatController {

	
	private final RestaurantService restaurantService;
	
	@PostMapping("/add")
	public ResponseEntity<HttpStatus> addRestaurnat(@RequestBody Restaurant restaurant) {
		
		restaurantService.addRestaurant(restaurant);
		return ResponseEntity.ok(HttpStatus.OK);
			
	}
	
	@GetMapping()
	public Restaurant getRestaurant(@RequestParam String restaurantName) {
		
		return restaurantService.getRestaurant(restaurantName).get();
		
	}
	
	@GetMapping("/category")
	public List<String> getCategory(@RequestParam String restaurantId){
		
		return restaurantService.getCategory(restaurantId);
		
	}
	
	
	
}
