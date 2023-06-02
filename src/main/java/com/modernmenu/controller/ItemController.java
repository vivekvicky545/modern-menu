package com.modernmenu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.modernmenu.dto.ItemRequestDTO;
import com.modernmenu.service.impl.ItemServiceImpl;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/item")
@CrossOrigin
@AllArgsConstructor
public class ItemController {

	
	private final ItemServiceImpl itemService;

	@PostMapping("/add")
	public ResponseEntity<HttpStatus> addItem(@RequestBody @Valid ItemRequestDTO itemDTO) {

		itemService.addItem(itemDTO);
		return ResponseEntity.ok(HttpStatus.OK);

	}

	@PatchMapping("/update")
	public ResponseEntity<HttpStatus> updateItem(@RequestParam String itemId,
			@RequestBody ItemRequestDTO itemRequestDTO) {

		itemService.updateItem(itemId, itemRequestDTO);
		return ResponseEntity.ok(HttpStatus.OK);

	}

	@DeleteMapping("/remove")
	public ResponseEntity<HttpStatus> removeItem(@RequestBody ItemRequestDTO itemRequestDTO) {

		itemService.removeItem(itemRequestDTO);
		return ResponseEntity.ok(HttpStatus.OK);

	}

	@PatchMapping("/notify")
	public ResponseEntity<HttpStatus> updateStatus(@RequestParam String itemId) {

		itemService.updateStatus(itemId);
		return ResponseEntity.ok(HttpStatus.OK);

	}

}
