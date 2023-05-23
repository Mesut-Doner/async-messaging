package com.mdoner.training.RabbitmqTutorial.shipping;

import com.mdoner.training.RabbitmqTutorial.common.AmqpConstants;
import com.mdoner.training.RabbitmqTutorial.events.OrderCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    @RabbitListener(queues = AmqpConstants.QUEUE_NAME_SHIPPING)
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        // Event handling logic for OrderCreatedEvent
        System.out.println("Received OrderCreatedEvent: " + event.getOrderId());

        // Perform shipping process for the order
        // ...
    }
}
