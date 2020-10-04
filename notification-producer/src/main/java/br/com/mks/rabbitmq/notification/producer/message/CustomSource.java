package br.com.mks.rabbitmq.notification.producer.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomSource {
    @Output("default-channel")
    MessageChannel sendMessageDefaultChannel();

    @Output("custom-channel")
    MessageChannel sendMessageCustomChannel();
}
