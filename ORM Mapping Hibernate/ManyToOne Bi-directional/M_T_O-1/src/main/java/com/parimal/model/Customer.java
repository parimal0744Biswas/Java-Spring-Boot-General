package com.parimal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;

	private String cName;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	private List<Account> accounts = new ArrayList<>();

}
