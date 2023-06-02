package com.modernmenu.service;

import java.util.List;
import java.util.Map;

import com.modernmenu.dto.ItemResponseDTO;

public interface MenuService {

	Map<String, List<ItemResponseDTO>> getMenu(String restaurantName);

}
