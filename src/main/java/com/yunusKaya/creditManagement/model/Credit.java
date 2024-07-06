package com.yunusKaya.creditManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="credit")
public class Credit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="castumer_name")
	private String castumerName;
	
	@Column(name="credit_amount")
	private double creditAmount;
	
	@Column(name="credit_term")
	private int creditTerm;
	
	@Column(name="credit_type")
	
	private CreditType creditType;
	
	
	
	
    
}
