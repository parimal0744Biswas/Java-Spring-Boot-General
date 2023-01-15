package com.parimal.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accNo;

	private String bankName;

	private Integer aBalance;

	@ManyToOne(cascade = CascadeType.DETACH)
	private Customer customer;

}
