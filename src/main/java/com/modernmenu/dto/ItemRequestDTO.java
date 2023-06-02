package com.modernmenu.dto;

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

	public String itemName;
	public double price;
	public String type;
	public String restaurantId;
	public String categoryName;
	
}
