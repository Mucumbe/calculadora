package com.Calculadora;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.Calculadora.domain.Result;


/**
 * @author Blandino Junior Sibone Mucumbe
 * Class responsible for implementing methods that consume messages in RabbitMQ
 * */
@Component
public class ResultConsumer {

	/**
	 * consume RabbitMQ message
	 * */
	@RabbitListener(queues = "RESULT")
	private void consumidor(Result result) {
		
		System.out.println(result.getId());
		System.out.println(result.getResult());
		
	}
}
