package com.Calculadora.service.validation;

import java.math.BigDecimal;

public class Validation {
	
	
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
