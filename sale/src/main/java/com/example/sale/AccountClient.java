package com.example.sale;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "localhost:8080", name = "account")
public interface AccountClient {

	@GetMapping("accounts/{id}")
	Account findById(@PathVariable long id);

	@PutMapping("/subtract")
	Account subtract(@RequestParam long id, @RequestParam double amount);
}
