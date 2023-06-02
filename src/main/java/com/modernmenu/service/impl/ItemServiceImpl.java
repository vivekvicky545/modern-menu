package com.modernmenu.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.modernmenu.dto.ItemRequestDTO;
import com.modernmenu.dto.ItemResponseDTO;
import com.modernmenu.entity.Category;
import com.modernmenu.entity.Item;
import com.modernmenu.exception.ResourceAlreadyExists;
import com.modernmenu.repository.CategoryRepository;
import com.modernmenu.repository.ItemRepository;
import com.modernmenu.service.ItemService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

	
	private final ItemRepository itemRepository;
	private final CategoryRepository categoryRepository;

	public void addItem(ItemRequestDTO itemDTO) {

		log.debug("addItem Request {}", itemDTO);

		Optional<ItemResponseDTO> isItemExitsInDB = itemRepository.getItem(itemDTO.getItemName(),
				itemDTO.getRestaurantId());

		if (isItemExitsInDB.isPresent()) {
			throw new ResourceAlreadyExists();
		}
		
		String categoryId = checkForCategoryAndGetCategoryId(itemDTO.getRestaurantId(), itemDTO.getCategoryName());

		Item newItem = new Item();

		newItem.setItemName(itemDTO.getItemName());
		newItem.setCategoryId(categoryId);
		newItem.setPrice(itemDTO.getPrice());
		newItem.setStatus(false);
		newItem.setType(itemDTO.getType());
		newItem.setStatus(true);

		itemRepository.saveAndFlush(newItem);

	}
	
	@Override
	public void updateItem(String itemId, ItemRequestDTO itemDTO) {

		log.debug("updateItem Request : {}", itemDTO);

		Item item = itemRepository.findById(itemId).get();

		item.setItemName(itemDTO.getItemName());
		item.setPrice(itemDTO.getPrice());
		item.setType(itemDTO.getType());

		String categoryId = checkForCategoryAndGetCategoryId(itemDTO.getRestaurantId(), itemDTO.getCategoryName());
		
		item.setCategoryId(categoryId);

		itemRepository.saveAndFlush(item);

	}

	@Override
	public void removeItem(ItemRequestDTO itemDTO) {
		
		Optional<ItemResponseDTO> item = itemRepository.getItem(itemDTO.getItemName(), itemDTO.getRestaurantId());
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
