package com.example.sale;

import lombok.Data;

@Data
public class Account {
	long id;

	String holder;

	double balance; // Balance in USD for this example
}
