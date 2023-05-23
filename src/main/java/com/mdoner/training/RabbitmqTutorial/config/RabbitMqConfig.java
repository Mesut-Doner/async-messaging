package com.mdoner.training.RabbitmqTutorial.config;

import com.mdoner.training.RabbitmqTutorial.common.AmqpConstants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMqConfig {
    @Value("${spring.rabbitmq.queue}")
    private String queue;
    @Value("${spring.rabbitmq.exchange}")
    private String exchange;
    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;
    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.host}")
    private String host;


    @Bean
    public FanoutExchange orderExchange() {
        return new FanoutExchange(AmqpConstants.EXCHANGE_NAME_ORDER);
    }

    @Bean
    public Queue shippingQueue() {
        return new Queue(AmqpConstants.QUEUE_NAME_SHIPPING);
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(AmqpConstants.QUEUE_NAME_NOTIFICATION);
    }

    @Bean
    public Binding shippingBinding(Queue shippingQueue, FanoutExchange orderExchange) {
        return BindingBuilder.bind(shippingQueue).to(orderExchange);
    }

    @Bean
    public Binding notificationBinding(Queue notificationQueue, FanoutExchange orderExchange) {
        return BindingBuilder.bind(notificationQueue).to(orderExchange);
    }
    @Bean
    public com.rabbitmq.client.ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        return cachingConnectionFactory.getRabbitConnectionFactory();
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }


}
