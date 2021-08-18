package com.Calculadora.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.Calculadora.domain.Result;

@Component
public class CalculatorService {
	
	private Result result;
	
	public CalculatorService() {
		
		result= new Result();
	}
	
	
	public Result sum(String firstValue,String secondValue ) {
		
		BigDecimal fV= new BigDecimal(firstValue);
		BigDecimal sV= new BigDecimal(secondValue);
		
		result.setResult(fV.add(sV).toString());
		
		return result;
	}
	
public Result subtraction(String firstValue,String secondValue ) {
		
		BigDecimal fV= new BigDecimal(firstValue);
		BigDecimal sV= new BigDecimal(secondValue);
		
		result.setResult(fV.subtract(sV).toString());
		
		return result ;
	}

public Result multiplication(String firstValue,String secondValue ) {
	
	BigDecimal fV= new BigDecimal(firstValue);
	BigDecimal sV= new BigDecimal(secondValue);
	
	result.setResult(fV.multiply(sV).toString());
	
	return result;
}
	
public Result division(String firstValue,String secondValue ) {
	
	BigDecimal fV= new BigDecimal(firstValue);
	BigDecimal sV= new BigDecimal(secondValue);
	
	result.setResult(fV.divide(sV).toString());
	
	return result;
}	

    
    }
