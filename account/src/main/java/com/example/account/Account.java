package com.example.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Account {
	@Id
	@GeneratedValue
	private long id;

	private String holder;

	private double balance; // Balance in USD for this example
}
