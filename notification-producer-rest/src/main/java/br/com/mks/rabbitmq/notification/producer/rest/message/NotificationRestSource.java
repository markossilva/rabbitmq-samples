package br.com.mks.rabbitmq.notification.producer.rest.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface NotificationRestSource {
    @Output("product-channel")
    MessageChannel sendMessage();
}
