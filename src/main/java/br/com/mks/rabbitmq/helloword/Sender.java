package br.com.mks.rabbitmq.helloword;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

public class Sender {
	private final static String QUEUE_NAME = "hello";
	private final static String ADDRESS_HOST = "localhost";

	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(ADDRESS_HOST);
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);

			for (int i = 0; i < 10; i++) {
				String message = "Hello Word " + i;
				channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
				System.out.println(" [x] sent '" + message + "'");
			}
		}
	}
}
