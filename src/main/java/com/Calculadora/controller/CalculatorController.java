package com.Calculadora.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

@Controller
public class CalculatorController {

	// @Autowired
	// private static final Logger
	// LOGGER=LoggerFactory.getLogger(CalculatorController.class);

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

	@GetMapping("/hello")
	@ResponseBody
	public String helo() {

		return "Ola";
	}

	@GetMapping("/sum")
	@ResponseBody
	public ResponseEntity<?> sum(@RequestParam("a") String firstValue, @RequestParam("b") String secondValue,
			HttpServletRequest request) {

		// LOGGER.trace("Execute Endpoit sum");
		// LOGGER.debug("Data : "+firstValue+"-"+secondValue);

		String requestKey = request.getHeader("Resquesr-Key");

		if (requestKey == null) {
			requestKey = UUID.randomUUID().toString();

		}
		MDC.put("ResquestKey", requestKey);

		if (!validation.approvParam(firstValue, secondValue)) {
			BadParam badParam = new BadParam(requestKey, "Bad param");

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)).body(badParam);

		} else {

			result = calculatorService.sum(firstValue, secondValue, requestKey);
			// result.setId(requestKey);

			this.rabbitMQService.sendMessage(RabbitMQConstant.ROW_RESULT, result);

			this.rabbitMQService.consumidor();

			// LOGGER.info("success");

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Resquesr-Key", requestKey);
			// return ResponseEntity.ok().body(result);

			return new ResponseEntity<Result>(result, responseHeaders, HttpStatus.OK);

		}

	}

	@GetMapping("/subtraction")
	@ResponseBody
	public ResponseEntity<?> subtraction(@RequestParam("a") String firstValue, @RequestParam("b") String secondValue,
			HttpServletRequest request) {
		
		// LOGGER.trace("Execute Endpoit subtraction");
		// LOGGER.debug("Data: "+firstValue+"-"+secondValue);

		
		String requestKey = request.getHeader("Resquesr-Key");

		if (requestKey == null) {
			requestKey = UUID.randomUUID().toString();

		}
		MDC.put("ResquestKey", requestKey);

		if (!validation.approvParam(firstValue, secondValue)) {
			BadParam badParam = new BadParam(requestKey, "Bad param");

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)).body(badParam);

		} else {

			Result result = calculatorService.subtraction(firstValue, secondValue, requestKey);
			// result.setId(requestKey);

			this.rabbitMQService.sendMessage(RabbitMQConstant.ROW_RESULT, result);

			this.rabbitMQService.consumidor();

			// LOGGER.info("success");

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Resquesr-Key", requestKey);
			// return ResponseEntity.ok().body(result);

			return new ResponseEntity<Result>(result, responseHeaders, HttpStatus.OK);

		}
	}

	@GetMapping("multiplication")
	@ResponseBody
	public ResponseEntity<?> multiplication(@RequestParam("a") String firstValue,
			@RequestParam("b") String secondValue,
			HttpServletRequest request) {

		// LOGGER.trace("Execute Endpoit multiplication");
		// LOGGER.debug("Dados da execucao : "+firstValue+"-"+secondValue);

		

		String requestKey = request.getHeader("Resquesr-Key");

		if (requestKey == null) {
			requestKey = UUID.randomUUID().toString();

		}
		MDC.put("ResquestKey", requestKey);

		if (!validation.approvParam(firstValue, secondValue)) {
			BadParam badParam = new BadParam(requestKey, "Bad param");

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)).body(badParam);

		} else {

			result = calculatorService.multiplication(firstValue, secondValue, requestKey);
			// result.setId(requestKey);

			this.rabbitMQService.sendMessage(RabbitMQConstant.ROW_RESULT, result);

			this.rabbitMQService.consumidor();

			// LOGGER.info("success");

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Resquesr-Key", requestKey);
			// return ResponseEntity.ok().body(result);

			return new ResponseEntity<Result>(result, responseHeaders, HttpStatus.OK);

		}
	}

	@GetMapping("division")
	@ResponseBody
	public ResponseEntity<?> division(@RequestParam("a") String firstValue, @RequestParam("b") String secondValue,
			HttpServletRequest request) {
		// LOGGER.trace("Execute Endpoit division");
		// LOGGER.debug("Dados da execucao : "+firstValue+"-"+secondValue);
		

		String requestKey = request.getHeader("Resquesr-Key");

		if (requestKey == null) {
			requestKey = UUID.randomUUID().toString();

		}
		MDC.put("ResquestKey", requestKey);

		if (!validation.approvParam(firstValue, secondValue)) {
			BadParam badParam = new BadParam(requestKey, "Bad param");

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)).body(badParam);

		} else {

			result = calculatorService.division(firstValue, secondValue, requestKey);
			// result.setId(requestKey);

			this.rabbitMQService.sendMessage(RabbitMQConstant.ROW_RESULT, result);

			this.rabbitMQService.consumidor();

			// LOGGER.info("success");

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Resquesr-Key", requestKey);
			// return ResponseEntity.ok().body(result);

			return new ResponseEntity<Result>(result, responseHeaders, HttpStatus.OK);

		}
	}

}
