package com.Calculadora.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CalculatorService {
	
	public String sum(String firstValue,String secondValue ) {
		
		BigDecimal fV= new BigDecimal(firstValue);
		BigDecimal sV= new BigDecimal(secondValue);
		
		return fV.add(sV).toString();
	}
	
public String subtraction(String firstValue,String secondValue ) {
		
		BigDecimal fV= new BigDecimal(firstValue);
		BigDecimal sV= new BigDecimal(secondValue);
		
		return fV.subtract(sV).toString();
	}

public String multiplication(String firstValue,String secondValue ) {
	
	BigDecimal fV= new BigDecimal(firstValue);
	BigDecimal sV= new BigDecimal(secondValue);
	
	return fV.multiply(sV).toString();
}
	
public String division(String firstValue,String secondValue ) {
	
	BigDecimal fV= new BigDecimal(firstValue);
	BigDecimal sV= new BigDecimal(secondValue);
	
	return fV.divide(sV).toString();
}	

    
    }
