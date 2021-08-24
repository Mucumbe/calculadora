package com.Calculadora.domain;

import java.io.Serializable;
import java.util.UUID;

public class Result implements Serializable {
	

	private UUID id;
	private String result;
	
	
	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
