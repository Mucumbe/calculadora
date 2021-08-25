package com.Calculadora.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Calculadora.domain.Result;

/**
 * @author Blandinop Junior sibone Mucumbe
 * Class responsible for implementing services for sending and receiving messages in RAbbitMq
 * */
@Service
public class RabbitMQService {

	/**
	 * Responsible for adding result to the message queue
	 * */
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendMessage(String nameRow,Object message) {
		
		this.rabbitTemplate.convertAndSend(nameRow,message);
	}
	
	
	/**
	 * Responsible for consuming messages on rabbitMQ
	 * */
	public void consumidor() {
		
		
	}
	
	
}
