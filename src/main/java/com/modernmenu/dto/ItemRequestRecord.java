package com.modernmenu.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ItemRequestRecord(
		
		@NotBlank(message = "Item name canot be blank") String itemName,
		@NotNull(message = "Price canot be blank") double price,
		@NotBlank(message = "Type canot be blank") String type,
		@NotBlank(message = "RestaurantId canot be blank") String restaurantId,
		@NotBlank(message = "Category name canot be blank") String categoryName
		
		) {}