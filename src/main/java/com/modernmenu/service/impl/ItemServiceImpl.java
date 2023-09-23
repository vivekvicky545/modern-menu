package com.modernmenu.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.modernmenu.dto.ItemRequestRecord;
import com.modernmenu.dto.ItemResponseDTO;
import com.modernmenu.entity.Category;
import com.modernmenu.entity.Item;
import com.modernmenu.exception.ResourceAlreadyExists;
import com.modernmenu.repository.CategoryRepository;
import com.modernmenu.repository.ItemRepository;
import com.modernmenu.service.ItemService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

	
	private final ItemRepository itemRepository;
	private final CategoryRepository categoryRepository;

	public void addItem(@Valid ItemRequestRecord itemRecord) {

		log.debug("addItem Request {}", itemRecord);

		Optional<ItemResponseDTO> isItemExitsInDB = itemRepository.getItem(itemRecord.itemName(),
				itemRecord.restaurantId());

		if (isItemExitsInDB.isPresent()) {
			throw new ResourceAlreadyExists();
		}
		
		String categoryId = checkForCategoryAndGetCategoryId(itemRecord.restaurantId(), itemRecord.categoryName());

		Item newItem = new Item();

		newItem.setItemName(itemRecord.itemName());
		newItem.setCategoryId(categoryId);
		newItem.setPrice(itemRecord.price());
		newItem.setStatus(false);
		newItem.setType(itemRecord.type());
		newItem.setStatus(true);

		itemRepository.saveAndFlush(newItem);

	}
	
	@Override
	public void updateItem(String itemId, ItemRequestRecord itemRecord) {

		log.debug("updateItem Request : {}", itemRecord);

		Item item = itemRepository.findById(itemId).get();

		item.setItemName(itemRecord.itemName());
		item.setPrice(itemRecord.price());
		item.setType(itemRecord.type());

		String categoryId = checkForCategoryAndGetCategoryId(itemRecord.restaurantId(), itemRecord.categoryName());
		
		item.setCategoryId(categoryId);

		itemRepository.saveAndFlush(item);

	}

	@Override
	public void removeItem(ItemRequestRecord itemRecord) {
		
		Optional<ItemResponseDTO> item = itemRepository.getItem(itemRecord.itemName(), itemRecord.restaurantId());
		itemRepository.deleteById(item.get().getItemId());

	}

	public void updateStatus(String itemId) {

		Item item = itemRepository.findById(itemId).get();
		item.setStatus(!item.isStatus());

		itemRepository.saveAndFlush(item);

	}

	public String checkForCategoryAndGetCategoryId(String restaurantId, String categoryName) {

		Optional<Category> isCategoryExitsInDB = categoryRepository.findByRestaurantIdAndCategoryName(restaurantId,
				categoryName);

		if (isCategoryExitsInDB.isPresent()) {
			return isCategoryExitsInDB.get().getCategoryId();
		}
		
		Category newCategory = new Category();

		newCategory.setRestaurantId(restaurantId);
		newCategory.setCategoryName(categoryName);

		newCategory = categoryRepository.saveAndFlush(newCategory);

		return newCategory.getCategoryId();

	}

}
