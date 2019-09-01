package com.example.sale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Sale {
	@Id
	@GeneratedValue
	private long id;

	private long accountId;

	private long inventoryId;

	private int amount;

	public Sale(long accountId, long inventoryId, int amount) {
		this.accountId = accountId;
		this.inventoryId = inventoryId;
		this.amount = amount;
	}
}
