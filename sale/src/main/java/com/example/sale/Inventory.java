package com.example.sale;

import lombok.Data;

@Data
public class Inventory {
	long id;

	String item;

	double price; // Sale price in USD for this example

	int count;
}
