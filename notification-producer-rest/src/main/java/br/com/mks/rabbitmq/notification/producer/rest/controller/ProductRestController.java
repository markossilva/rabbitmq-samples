package br.com.mks.rabbitmq.notification.producer.rest.controller;

import br.com.mks.rabbitmq.notification.producer.rest.dto.Message;
import br.com.mks.rabbitmq.notification.producer.rest.dto.Product;
import br.com.mks.rabbitmq.notification.producer.rest.message.NotificationRestSource;
import br.com.mks.rabbitmq.notification.producer.rest.message.producer.NotificationRestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    private NotificationRestSource source;

    @Autowired
    private NotificationRestProducer producer;

    @PostMapping("/process")
    public ResponseEntity<Message> processProduct(@RequestBody Product product) {
        boolean result = producer.sendMessageProduct(product, source);
        Message message = new Message("Operação realizada com sucesso? " + result);
        return ResponseEntity.ok(message);
    }
}
