package com.example.account;

import java.util.Optional;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AccountController {

	private final AccountRepository accountRepository;

	@PutMapping("/subtract")
	public ResponseEntity<?> subtract(@RequestParam long id, @RequestParam double amount) {
		Optional<Account> accountOptional = accountRepository.findById(id);
		if (accountOptional.isEmpty()) {
			return new ResponseEntity<>("Could not find id:" + id, HttpStatus.NOT_FOUND);
		}

		Account account = accountOptional.get();

		if (account.getBalance() < amount) {
			return new ResponseEntity<>("Insufficient funds!", HttpStatus.BAD_REQUEST);
		}

		account.setBalance(account.getBalance() - amount);

		return new ResponseEntity<>(accountRepository.save(account), HttpStatus.OK);
	}
}
