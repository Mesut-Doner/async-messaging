package com.mdoner.training.RabbitmqTutorial.shipping;

import com.mdoner.training.RabbitmqTutorial.events.OrderCreatedEvent;
import com.mdoner.training.RabbitmqTutorial.shipping.model.dto.ShippingDTO;
import com.mdoner.training.RabbitmqTutorial.shipping.model.mapper.ShippingMapper;
import com.mdoner.training.RabbitmqTutorial.shipping.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShippingService {

    private final ShippingRepository shippingRepository;

    public ShippingService(@Autowired ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    public void createShippingForOrder(OrderCreatedEvent event) {
        System.out.println("Shipping for order " + event.getOrderId() + " created");

        ShippingDTO shippingDTO = ShippingDTO.builder()
                .id(UUID.randomUUID().toString())
                .notes("test")
                .name("test")
                .state("shipped")
                .address("created")
                .build();

        shippingRepository.save(ShippingMapper.INSTANCE.toEntity(shippingDTO));


    }
}
