package com.example.inventory;

import java.util.Optional;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class InventoryController {

	private final InventoryRepository inventoryRepository;

	@PutMapping("subtract")
	public ResponseEntity<?> subtract(@RequestParam long id, @RequestParam int amount) {
		Optional<Inventory> accountOptional = inventoryRepository.findById(id);
		if (accountOptional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Inventory account = accountOptional.get();

		if (account.getCount() < amount) {
			return new ResponseEntity<>("Insufficient inventory!", HttpStatus.BAD_REQUEST);
		}

		account.setCount(account.getCount() - amount);

		return new ResponseEntity<>(inventoryRepository.save(account), HttpStatus.OK);
	}
}
