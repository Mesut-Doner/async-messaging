package com.mdoner.training.RabbitmqTutorial.controller;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping(value = "/messaging")
public class RabbitMessageController {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMessageController(@Autowired RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        MessageProperties       properties = new MessageProperties();

        Message message = new Message("selamlar".getBytes(StandardCharsets.UTF_8), properties);

        rabbitTemplate.convertAndSend("exchange-test", "rk-test", message);
        return "Hello World!";
    }
}
