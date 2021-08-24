package com.Calculadora.domain;

import java.util.UUID;

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
