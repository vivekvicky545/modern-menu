package com.modernmenu.service;

import java.util.List;
import java.util.Optional;

import com.modernmenu.entity.Restaurant;

public interface RestaurantService {

	Restaurant addRestaurant(Restaurant restaurant);
	void removeRestaurant(Restaurant restaurant);
	void updateRestaurant(Restaurant restaurant);
	Optional<Restaurant> getRestaurant(String restaurantName);
	Restaurant findByrestaurantId(String restaurantId);
	List<String> getCategory(String restaurantId);
	
}
