package com.mdoner.training.RabbitmqTutorial.events;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreatedEvent {

    private String orderId;

    private String customerName;

}
