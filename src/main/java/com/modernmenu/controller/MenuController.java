package com.modernmenu.controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.modernmenu.dto.ItemResponseDTO;
import com.modernmenu.service.MenuService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/menu")
@CrossOrigin
@AllArgsConstructor
public class MenuController {
	
	private final MenuService menuService;
	
	@GetMapping
	public Map<String, List<ItemResponseDTO>> getMenu(@RequestParam String restaurantName) {
		
		return menuService.getMenu(restaurantName);
		
	}

}
