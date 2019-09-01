package com.example.sale;

import feign.FeignException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SaleController {

	private final SaleService saleService;

	private final AccountClient accountClient;

	private final InventoryClient inventoryClient;

	@ExceptionHandler(FeignException.class)
	public ResponseEntity<String> clientError(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@GetMapping("sell")
	public Sale sell(@RequestParam long accountId, @RequestParam long inventoryId, @RequestParam int amount) {
		Account account = accountClient.findById(accountId);
		Inventory inventory = inventoryClient.findById(inventoryId);
		return saleService.sale(account, inventory, amount);
	}
}
