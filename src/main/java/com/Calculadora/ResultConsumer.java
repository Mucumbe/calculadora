package com.Calculadora;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.Calculadora.domain.Result;


@Component
public class ResultConsumer {

	@RabbitListener(queues = "RESULT")
	private void consumidor(Result result) {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println(result.getResult());
	}
}
