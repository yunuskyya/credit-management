package com.yunusKaya.creditManagement.controller;



import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yunusKaya.creditManagement.dto.CreateCreditRequest;
import com.yunusKaya.creditManagement.model.Credit;
import com.yunusKaya.creditManagement.service.CreditService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/credit")
@AllArgsConstructor
public class CreditController {
	
	private CreditService creditService;
	
	
	@GetMapping()
	public List<Credit> getAllCredits() {
		return this.creditService.getAllCredits();
	}
	@PostMapping("/create")
	public void createCredit(@RequestBody CreateCreditRequest createCreditRequest) {
		this.creditService.createCredit(createCreditRequest);	
	}
	@PostMapping("/{id}")
	public void deleteCredit(Long id) {
		this.creditService.deleteCredit(id);
	}
	@GetMapping("/{id}")
	public Credit getCreditById(Long id) {
		return this.creditService.getCreditById(id);
	}


}
