package com.yunusKaya.creditManagement.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.yunusKaya.creditManagement.model.CreditType;

@Component
public class CreditCalculator {
    private static final Logger logger = LoggerFactory.getLogger(CreditCalculator.class);
    
    public double calculateInterestRate(CreditType creditType, int creditTerm) {
        double baseRate;
        logger.debug("Kredi türü: {} ve vade: {} için faiz oranı hesaplanıyor", creditType, creditTerm);
        
        switch (creditType) {
            case IHTIYAC_KREDISI:
                baseRate = 0.15;
                break;
            case KONUT_KREDISI:
                baseRate = 0.10;
                break;
            case TASIT_KREDISI:
                baseRate = 0.12;
                break;
            default:
                throw new IllegalArgumentException("Geçersiz kredi türü: " + creditType);
        }

        if (creditTerm > 24) {
            baseRate += 0.02;
        } else if (creditTerm > 12) {
            baseRate += 0.01;
        }

        logger.info("Hesaplanan faiz oranı: {}", baseRate);
        return baseRate;
    }


    public double calculateMonthlyPayment(double krediTutari, double annualInterestRate, int creditTerm) {
        double monthlyInterestRate = annualInterestRate / 12;
        int totalMonths = creditTerm * 12;
        
        double monthlyPayment = (krediTutari * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -totalMonths));
        logger.info("Calculated monthly payment: {}", monthlyPayment);
        
        return monthlyPayment;
    }
}


