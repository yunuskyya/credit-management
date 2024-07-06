package com.yunusKaya.creditManagement.dto;

import com.yunusKaya.creditManagement.model.CreditType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditRequest {
	
	private String castumerName;
	private double creditAmount;
	private int creditTerm;
	private CreditType creditType;
	

}
