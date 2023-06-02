package com.modernmenu.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ItemRequestDTO {

	@NotBlank(message = "Item name canot be blank")
	public String itemName;
	@NotNull(message = "Price canot be blank")
	public double price;
	@NotBlank(message = "Type canot be blank")
	public String type;
	@NotBlank(message = "RestaurantId canot be blank")
	public String restaurantId;
	@NotBlank(message = "Category name canot be blank")
	public String categoryName;
	
}
