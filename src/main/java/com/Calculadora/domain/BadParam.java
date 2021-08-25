package com.Calculadora.domain;

import java.util.UUID;

/**
 * @author Blandino Junior Sibone Mucumbe
 * This is the domain of the result of the response of parameters not accepted by the calculator
 * */
public class BadParam {
	
	private String id;
	private String status;
	
	
	
	public BadParam(String id, String status) {
		this.id = id;
		this.status = status;
	}
	
	public String getId() {
		return id;
	}
	
	public String getStatus() {
		return status;
	}
	
	
	
	
	

}
