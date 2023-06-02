package com.modernmenu.service;

import com.modernmenu.dto.ItemRequestDTO;

public interface ItemService {

	void addItem(ItemRequestDTO itemDTO);
	void updateItem(String itemId, ItemRequestDTO itemDTO);
	void removeItem(ItemRequestDTO itemDTO);
	void updateStatus(String itemId);
	
}
