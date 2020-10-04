package br.com.mks.rabbitmq.notification.producer.rest.message.producer;

import br.com.mks.rabbitmq.notification.producer.rest.dto.Product;
import br.com.mks.rabbitmq.notification.producer.rest.message.NotificationRestSource;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class NotificationRestProducer {

    public boolean sendMessageProduct(Product payload, NotificationRestSource source) {
        return source.sendMessage()
                .send(MessageBuilder
                        .withPayload(payload).build()
                );
    }
}
