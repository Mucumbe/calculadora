package com.Calculadora.service;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.Calculadora.domain.Result;

@Component
public class CalculatorService {
	
	private Result result;
	
	public CalculatorService() {
		
		result= new Result();
	}
	
	
	public Result sum(String firstValue,String secondValue,String id ) {
		
		BigDecimal fV= new BigDecimal(firstValue);
		BigDecimal sV= new BigDecimal(secondValue);
		
		result.setResult(fV.add(sV).toString());
		result.setId(UUID.fromString(id));
		
		return result;
	}
	
public Result subtraction(String firstValue,String secondValue,String id ) {
		
		BigDecimal fV= new BigDecimal(firstValue);
		BigDecimal sV= new BigDecimal(secondValue);
		
		result.setResult(fV.subtract(sV).toString());
		result.setId(UUID.fromString(id));
		
		return result ;
	}

public Result multiplication(String firstValue,String secondValue,String id ) {
	
	BigDecimal fV= new BigDecimal(firstValue);
	BigDecimal sV= new BigDecimal(secondValue);
	
	result.setResult(fV.multiply(sV).toString());
	result.setId(UUID.fromString(id));
	
	return result;
}
	
public Result division(String firstValue,String secondValue,String id ) {
	
	BigDecimal fV= new BigDecimal(firstValue);
	BigDecimal sV= new BigDecimal(secondValue);
	
	result.setResult(fV.divide(sV).toString());
	result.setId(UUID.fromString(id));
	
	return result;
}	

    
    }
