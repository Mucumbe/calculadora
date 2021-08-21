package com.Calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Calculadora.conection.RabbitMQConstant;
import com.Calculadora.domain.Result;
import com.Calculadora.service.CalculatorService;
import com.Calculadora.service.RabbitMQService;


@Controller
public class CalculatorController {
	
	//@Autowired
	//private static final Logger LOGGER=LoggerFactory.getLogger(CalculatorController.class);
	
	private CalculatorService calculatorService;
	Result result;
	
	@Autowired
	private RabbitMQService rabbitMQService;
	
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
		
	//LOGGER.trace("Execute Endpoit sum");
	//LOGGER.debug("Data : "+firstValue+"-"+secondValue);
	
	result=calculatorService.sum(firstValue, secondValue);
	
	this.rabbitMQService.sendMessage(RabbitMQConstant.ROW_RESULT, result);
	//LOGGER.info("success");

	return ResponseEntity.ok().body(result);
}


@GetMapping("/subtraction")
@ResponseBody
public ResponseEntity<?> subtraction(@RequestParam("a") String firstValue,@RequestParam("b") String secondValue){
	//LOGGER.trace("Execute Endpoit subtraction");
	//LOGGER.debug("Data: "+firstValue+"-"+secondValue);
		
	Result result=calculatorService.subtraction(firstValue, secondValue);

	this.rabbitMQService.sendMessage(RabbitMQConstant.ROW_RESULT, result);
	//LOGGER.info("success");
	return ResponseEntity.ok().body(result);
	}


@GetMapping("multiplication")
@ResponseBody
public ResponseEntity<?> multiplication(@RequestParam("a") String firstValue,@RequestParam("b") String secondValue){
	
	//LOGGER.trace("Execute Endpoit multiplication");
	//LOGGER.debug("Dados da execucao : "+firstValue+"-"+secondValue);
	
	result=calculatorService.multiplication(firstValue, secondValue);
	
	this.rabbitMQService.sendMessage(RabbitMQConstant.ROW_RESULT, result);
	//LOGGER.info("success");
	return ResponseEntity.ok().body(result);
}


@GetMapping("division")
@ResponseBody
public ResponseEntity<?> division(@RequestParam("a") String firstValue,@RequestParam("b") String secondValue){
	//LOGGER.trace("Execute Endpoit division");
	//LOGGER.debug("Dados da execucao : "+firstValue+"-"+secondValue);
	result=calculatorService.division(firstValue, secondValue);
	
	this.rabbitMQService.sendMessage(RabbitMQConstant.ROW_RESULT, result);
	//LOGGER.info("success");
	return ResponseEntity.ok().body(result);
}
	
	
}
