package com.Calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Calculadora.service.CalculatorService;

@Controller
public class CalculatorController {
	

	private CalculatorService calculatorService;
	
	@Autowired
	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
	
	
	@GetMapping("/hello")
	@ResponseBody
	public String helo() {
		
		return "Ola";
	}

		
@GetMapping("/sum")
@ResponseBody
public String sum(@RequestParam("a") String firstValue,@RequestParam("b") String secondValue){
		
	return calculatorService.sum(firstValue, secondValue);
}

@GetMapping("/subtraction")
@ResponseBody
public String subtraction(@RequestParam("a") String firstValue,@RequestParam("b") String secondValue){
		
		return calculatorService.subtraction(firstValue, secondValue);
	}

@GetMapping("multiplication")
@ResponseBody
public String multiplication(@RequestParam("a") String firstValue,@RequestParam("b") String secondValue){
	
	return calculatorService.multiplication(firstValue, secondValue);
}

@GetMapping("division")
@ResponseBody
public String division(@RequestParam("a") String firstValue,@RequestParam("b") String secondValue){
	
	return calculatorService.division(firstValue, secondValue);
}
	
	
}
