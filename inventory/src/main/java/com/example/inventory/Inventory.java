package com.example.inventory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Inventory {
	@Id
	@GeneratedValue
	private long id;

	private String item;

	private double price; // Sale price in USD for this example

	private int count;
}
