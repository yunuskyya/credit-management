package com.yunusKaya.creditManagement.service;

import java.util.List;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunusKaya.creditManagement.dto.CreateCreditRequest;
import com.yunusKaya.creditManagement.model.Credit;
import com.yunusKaya.creditManagement.repository.CreditRepository;



@Service
public class CreditService {
	@Autowired
	public CreditRepository creditRepository;
	@Autowired
    private CreditCalculator creditCalculator;
	public CreditService(CreditRepository creditRepository) {
		this.creditRepository = creditRepository;
	}
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(CreditService.class);
	
	public List<Credit> getAllCredits() {
		return this.creditRepository.findAll();
	}
	
	
	public void createCredit(CreateCreditRequest createCreditRequest) {
        logger.debug("Creating credit for request: {}", createCreditRequest);

		Credit credit = new Credit();
		credit.setCastumerName(createCreditRequest.getCastumerName());
		credit.setCreditAmount(createCreditRequest.getCreditAmount());
		credit.setCreditTerm(createCreditRequest.getCreditTerm());
		credit.setCreditType(createCreditRequest.getCreditType());
		 logger.info("Saving credit: {}", credit);
		
	    double faizOrani = creditCalculator.calculateInterestRate(credit.getCreditType(), credit.getCreditTerm());
        double aylikOdeme = creditCalculator.calculateMonthlyPayment(credit.getCreditAmount(), faizOrani, credit.getCreditTerm());
        
        logger.info("faiz oranı: {}", faizOrani);
        logger.info("Aylık ödeme: {}", aylikOdeme);
       
		this.creditRepository.save(credit);
		logger.info("Credit saved successfully with id: {}", credit.getId());
	}
	
	public void deleteCredit(Long id) {
		this.creditRepository.deleteById(id);
	}
	
	
	public Credit getCreditById(Long id) {
		return this.creditRepository.findById(id).orElse(null);
	}
	
	

}
