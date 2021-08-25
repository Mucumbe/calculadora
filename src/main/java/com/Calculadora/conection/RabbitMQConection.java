package com.Calculadora.conection;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

/**
* @author Danilo Caneschi
* Protocol implementation responsible for creating communication with RabbitMQ
* Standard implementation
* */
@Component
public class RabbitMQConection {
	
	public AmqpAdmin amqpAdmin;
	public RabbitMQConection(AmqpAdmin amqpAdmin) {
		
		this.amqpAdmin=amqpAdmin;
	}
	
	private static final String NAME_EXCHANGE="amq.direct";

	private Queue row(String nameRow) {
		
		return new Queue(nameRow, true , false , false );
	}
	
	private DirectExchange directExchange() {
		
		return  new DirectExchange(NAME_EXCHANGE);
	}
	
	private Binding relation (Queue row,DirectExchange exchange) {
		
		return new Binding(row.getName(),Binding.DestinationType.QUEUE, exchange.getName(), row.getName(), null);
	}
	
	@PostConstruct
	private void add() {
		
		Queue rowResult=this.row(RabbitMQConstant.ROW_RESULT);
		
		DirectExchange exchange=this.directExchange();
		
		Binding linkResult=this.relation(rowResult, exchange);
		
		this.amqpAdmin.declareQueue(rowResult);
		
		this.amqpAdmin.declareExchange(exchange);
		
		this.amqpAdmin.declareBinding(linkResult);
		
		
		
	}
}
