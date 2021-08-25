package com.Calculadora.service.validation;

import java.math.BigDecimal;


/**
 * @author Blandino Junior Sibone Mucumbe
 * Class responsible for validating parameters7
 * */
public class Validation {
	
	/**
	 * receives data by parameters to validate
	 * */
	public Boolean approvParam(String a, String b) {
		
		
		a=a.trim();
		b=b.trim();
		
		try {
			BigDecimal var1= new BigDecimal(a);
			BigDecimal var2= new BigDecimal(b);
			return true;
						
		} catch (NumberFormatException e) {
			
			return false;
		}
		
	}

}
