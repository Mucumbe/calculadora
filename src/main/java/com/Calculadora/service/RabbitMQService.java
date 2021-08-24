package com.Calculadora.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Calculadora.domain.Result;

@Service
public class RabbitMQService {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendMessage(String nameRow,Object message) {
		
		this.rabbitTemplate.convertAndSend(nameRow,message);
	}
	
	
	
	public void consumidor() {
		
		//String esult=(String)rabbitTemplate.receiveAndConvert("RESULT");
		//System.out.println("kkkkkkkkk"+esult);
		
		
		;
	}
	
	
}
