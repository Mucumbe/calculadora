package com.Calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Calculadora.domain.Result;
import com.Calculadora.service.CalculatorService;

@Controller
public class CalculatorController {
	

	private CalculatorService calculatorService;
	Result result;
	
	
	@Autowired
	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
		result= new Result();
	}
	
	
	@GetMapping("/hello")
	@ResponseBody
	public String helo() {
		
		return "Ola";
	}

		
@GetMapping("/sum")
@ResponseBody
public ResponseEntity<?> sum(@RequestParam("a") String firstValue,@RequestParam("b") String secondValue){
		
	result=calculatorService.sum(firstValue, secondValue);

	return ResponseEntity.ok().body(result);
}

@GetMapping("/subtraction")
@ResponseBody
public ResponseEntity<?> subtraction(@RequestParam("a") String firstValue,@RequestParam("b") String secondValue){
		
	Result result=calculatorService.subtraction(firstValue, secondValue);

	return ResponseEntity.ok().body(result);
	}

@GetMapping("multiplication")
@ResponseBody
public ResponseEntity<?> multiplication(@RequestParam("a") String firstValue,@RequestParam("b") String secondValue){
	
	result=calculatorService.multiplication(firstValue, secondValue);
	
	return ResponseEntity.ok().body(result);
}

@GetMapping("division")
@ResponseBody
public ResponseEntity<?> division(@RequestParam("a") String firstValue,@RequestParam("b") String secondValue){
	
	result=calculatorService.division(firstValue, secondValue);
	
	return ResponseEntity.ok().body(result);
}
	
	
}
