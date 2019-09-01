package com.example.sale;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SaleService {

	private final AccountClient accountClient;

	private final InventoryClient inventoryClient;

	private final SaleRepository saleRepository;

	Sale sale(Account account, Inventory inventory, int amount) {
		log.info("Attempting to make sale. Account: {}, Inventory:{}, amount:{}", account, inventory, amount);

		accountClient.subtract(account.getId(), inventory.getPrice() * amount);
		inventoryClient.subtract(inventory.getId(), amount);

		Sale sale = new Sale(account.getId(), inventory.getId(), amount);

		return saleRepository.save(sale);
	}
}
