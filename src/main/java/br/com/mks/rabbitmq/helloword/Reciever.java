package br.com.mks.rabbitmq.helloword;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;

public class Reciever {
	private final static String QUEUE_NAME = "hello";
	private final static String ADDRESS_HOST = "localhost";

	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(ADDRESS_HOST);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		channel.basicConsume(QUEUE_NAME, true, deliverSuccess(), deliverCanceled());
	}

	private static CancelCallback deliverCanceled() {
		return consumerTag -> {
		};
	}

	private static DeliverCallback deliverSuccess() {
		return (consumer, deliver) -> {
			String message = new String(deliver.getBody(), StandardCharsets.UTF_8);
			System.out.println(" [x] Received '".concat(message).concat("'"));
		};
	}
}
