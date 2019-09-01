package com.example.sale;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "localhost:8081", name = "inventory")
public interface InventoryClient {

	@GetMapping("inventories/{id}")
	Inventory findById(@PathVariable Long id);

	@PutMapping("subtract")
	Account subtract(@RequestParam long id, @RequestParam int amount);
}
