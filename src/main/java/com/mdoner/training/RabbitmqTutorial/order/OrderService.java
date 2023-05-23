package com.mdoner.training.RabbitmqTutorial.order;

import com.mdoner.training.RabbitmqTutorial.common.AmqpConstants;
import com.mdoner.training.RabbitmqTutorial.events.OrderCreatedEvent;
import com.mdoner.training.RabbitmqTutorial.order.model.dto.OrderDTO;
import com.mdoner.training.RabbitmqTutorial.order.model.mapper.OrderMapper;
import com.mdoner.training.RabbitmqTutorial.order.repository.OrderRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final RabbitTemplate rabbitTemplate;


    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    public OrderService(@Autowired RabbitTemplate rabbitTemplate, @Autowired OrderRepository orderRepository, @Autowired OrderMapper orderMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public void createOrder(OrderDTO orderDTO) {
        // dbye kaydet
        orderRepository.save(orderMapper.orderDTOToOrder(orderDTO));
        // OrderCreatedEvent'i oluştur
        OrderCreatedEvent event = new OrderCreatedEvent(orderDTO.getOrderId(), orderDTO.getCustomerName());

        // OrderCreatedEvent'i kuyruğa gönder
        rabbitTemplate.convertAndSend(AmqpConstants.EXCHANGE_NAME_ORDER, AmqpConstants.ROUTING_KEY_ORDER, event);
    }
}
