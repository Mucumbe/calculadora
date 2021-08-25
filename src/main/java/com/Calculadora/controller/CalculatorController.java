package com.Calculadora.controller;


import java.util.UUID;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.Calculadora.conection.RabbitMQConstant;
import com.Calculadora.domain.BadParam;
import com.Calculadora.domain.Result;
import com.Calculadora.service.CalculatorService;
import com.Calculadora.service.RabbitMQService;
import com.Calculadora.service.validation.Validation;


/**
 * @author Blandino Junior Sibone Mucumbe
 * Controller Responsible for endpoints from calculator 
 * */
@Controller
public class CalculatorController {

	Logger logger = Logger.getLogger(getClass().getName());

	private CalculatorService calculatorService;
	private Result result;
	private Validation validation;

	@Autowired
	private RabbitMQService rabbitMQService;

	@Autowired
	public CalculatorController(CalculatorService calculatorService) {

		this.calculatorService = calculatorService;
		result = new Result();
		validation = new Validation();

	}

	/**
	* Method is responsible for executing sum endpoit
	* Receives Parameter "a" and "b"
	* performs addition operation
	* Save the result in the RabbitMQ queue
	* Returns the result to the Consumer
	* */
	@GetMapping("/sum")
	@ResponseBody
	public ResponseEntity<?> sum(@RequestParam("a") String firstValue, @RequestParam("b") String secondValue,
			HttpServletRequest request) {

		logger.info("executed program");
		logger.info("Param A: " + firstValue);
		logger.info("param B: " + secondValue);
		String requestKey = request.getHeader("Resquesr-Key");

		if (requestKey == null) {

			requestKey = UUID.randomUUID().toString();
		}
		MDC.put("ResquestKey", requestKey);

		if (!validation.approvParam(firstValue, secondValue)) {

			logger.warning("Error : " + "Bad Parameter");
			BadParam badParam = new BadParam(requestKey, "Bad param");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)).body(badParam);
		} else {

			logger.info("calculating sum...");

			result = calculatorService.sum(firstValue, secondValue, requestKey);
			
			this.rabbitMQService.sendMessage(RabbitMQConstant.ROW_RESULT, result);
			
			
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Resquesr-Key", requestKey);
			logger.info("success");
			
			return new ResponseEntity<Result>(result, responseHeaders, HttpStatus.OK);
			
		}

	}

	/**
	* Method is responsible for executing subtraction  endpoit
	* Receives Parameter "a" and "b"
	* performs subtraction operation
	* Save the result in the RabbitMQ queue
	* Returns the result to the Consumer
	* */
	@GetMapping("/subtraction")
	@ResponseBody
	public ResponseEntity<?> subtraction(@RequestParam("a") String firstValue, @RequestParam("b") String secondValue,
			HttpServletRequest request) {

		logger.info("executed program");
		logger.info("Param A: " + firstValue);
		logger.info("param B: " + secondValue);

		String requestKey = request.getHeader("Resquesr-Key");

		if (requestKey == null) {

			requestKey = UUID.randomUUID().toString();
		}
		MDC.put("ResquestKey", requestKey);

		if (!validation.approvParam(firstValue, secondValue)) {

			logger.warning("Error : " + "Bad Parameter");
			BadParam badParam = new BadParam(requestKey, "Bad param");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)).body(badParam);
		} else {

			logger.info("calculating subtraction...");

			result = calculatorService.subtraction(firstValue, secondValue, requestKey);
			
			this.rabbitMQService.sendMessage(RabbitMQConstant.ROW_RESULT, result);
			


			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Resquesr-Key", requestKey);
			logger.info("success");
			
			return new ResponseEntity<Result>(result, responseHeaders, HttpStatus.OK);
		}
	}

	/**
	* Method is responsible for executing multiplication  endpoit
	* -Receives Parameter "a" and "b"
	* -performs multiplication operation
	* -Save the result in the RabbitMQ queue
	* -Returns the result to the Consumer
	* */
	@GetMapping("multiplication")
	@ResponseBody
	public ResponseEntity<?> multiplication(@RequestParam("a") String firstValue, @RequestParam("b") String secondValue,
			HttpServletRequest request) {

		logger.info("executed program");
		logger.info("Param A: " + firstValue);
		logger.info("param B: " + secondValue);

		String requestKey = request.getHeader("Resquesr-Key");

		if (requestKey == null) {

			requestKey = UUID.randomUUID().toString();
		}
		MDC.put("ResquestKey", requestKey);

		if (!validation.approvParam(firstValue, secondValue)) {

			logger.warning("Error : " + "Bad Parameter");
			BadParam badParam = new BadParam(requestKey, "Bad param");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)).body(badParam);
		} else {

			logger.info("calculating multiplication...");

			result = calculatorService.multiplication(firstValue, secondValue, requestKey);
			
			this.rabbitMQService.sendMessage(RabbitMQConstant.ROW_RESULT, result);
			


			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Resquesr-Key", requestKey);
			logger.info("success");
			
			return new ResponseEntity<Result>(result, responseHeaders, HttpStatus.OK);
		}
	}

	/**
	* Method is responsible for executing division  endpoit
	* -Receives Parameter "a" and "b"
	* -performs division operation
	*- Save the result in the RabbitMQ queue
	* -Returns the result to the Consumer
	* */
	@GetMapping("division")
	@ResponseBody
	public ResponseEntity<?> division(@RequestParam("a") String firstValue, @RequestParam("b") String secondValue,
			HttpServletRequest request) {
		logger.info("executed program");
		logger.info("Param A: " + firstValue);
		logger.info("param B: " + secondValue);

		String requestKey = request.getHeader("Resquesr-Key");

		if (requestKey == null) {

			requestKey = UUID.randomUUID().toString();
		}
		MDC.put("ResquestKey", requestKey);

		if (!validation.approvParam(firstValue, secondValue)) {

			logger.warning("Error : " + "Bad Parameter");
			BadParam badParam = new BadParam(requestKey, "Bad param");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)).body(badParam);
		} else {

			logger.info("calculating division...");

			result = calculatorService.division(firstValue, secondValue, requestKey);
			
			this.rabbitMQService.sendMessage(RabbitMQConstant.ROW_RESULT, result);
			


			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Resquesr-Key", requestKey);
			logger.info("success");
			
			return new ResponseEntity<Result>(result, responseHeaders, HttpStatus.OK);
		}
	}

}
