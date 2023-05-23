package com.mdoner.training.RabbitmqTutorial.order.model.dto;


import lombok.Data;

@Data
public class OrderDTO {

    private String orderId;
    private String customerId;
    private String customerName;
    private String shippingId;
    private String orderName;
}
