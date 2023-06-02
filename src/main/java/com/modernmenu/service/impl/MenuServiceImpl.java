package com.modernmenu.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.modernmenu.dto.ItemResponseDTO;
import com.modernmenu.repository.ItemRepository;
import com.modernmenu.service.MenuService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {
	
	private final ItemRepository itemRepository;

	@Override
	public Map<String, List<ItemResponseDTO>> getMenu(String restaurantName) {
		
		
		List<ItemResponseDTO> menuList = itemRepository.getMenu(restaurantName);
		Map<String, List<ItemResponseDTO>> menuMap = menuList.stream()
														.sorted(Comparator.comparing(ItemResponseDTO::getPrice))
														.sorted(Comparator.comparing(ItemResponseDTO::getStatus,Collections.reverseOrder()))
														.collect(Collectors.groupingBy(ItemResponseDTO::getCategoryName));
		
		return menuMap;
		
	}

}
