package com.modernmenu.service;

import com.modernmenu.dto.ItemRequestRecord;

public interface ItemService {

	void addItem(ItemRequestRecord itemDTO);
	void updateStatus(String itemId);
	void updateItem(String itemId, ItemRequestRecord itemRecord);
	void removeItem(ItemRequestRecord itemRecord);
	
}
