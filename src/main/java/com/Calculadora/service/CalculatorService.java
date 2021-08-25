package com.Calculadora.service;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.Calculadora.domain.Result;


/**
 *@author Blandino Junior sibone Mucumbe
 * Class responsible for performing services of the 4 basic operations of the calculator
 */
@Component
public class CalculatorService {

	private Result result;

	public CalculatorService() {

		result = new Result();
	}

	/**
	 * receives two parameters a and b
	 * perform sum
	 * returns result
	 * */
	public Result sum(String firstValue, String secondValue, String id) {

		BigDecimal fV = new BigDecimal(firstValue);
		BigDecimal sV = new BigDecimal(secondValue);

		result.setResult(fV.add(sV).toString());
		result.setId(UUID.fromString(id));

		return result;
	}

	/**
	 * receives two parameters a and b
	 * perform subtraction
	 * return result
	 * */
	public Result subtraction(String firstValue, String secondValue, String id) {

		BigDecimal fV = new BigDecimal(firstValue);
		BigDecimal sV = new BigDecimal(secondValue);

		result.setResult(fV.subtract(sV).toString());
		result.setId(UUID.fromString(id));

		return result;
	}

	/**
	 * receives two parameters a and b
	 * perform multiplication
	 * return result
	 * */
	public Result multiplication(String firstValue, String secondValue, String id) {

		BigDecimal fV = new BigDecimal(firstValue);
		BigDecimal sV = new BigDecimal(secondValue);

		result.setResult(fV.multiply(sV).toString());
		result.setId(UUID.fromString(id));

		return result;
	}

	/**
	 * receives two parameters a and b
	 * perform division
	 * return result
	 * */
	public Result division(String firstValue, String secondValue, String id) {

		BigDecimal fV = new BigDecimal(firstValue);
		BigDecimal sV = new BigDecimal(secondValue);

		result.setResult(fV.divide(sV).toString());
		result.setId(UUID.fromString(id));

		return result;
	}

}
