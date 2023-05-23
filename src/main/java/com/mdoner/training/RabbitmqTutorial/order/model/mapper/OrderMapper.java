package com.mdoner.training.RabbitmqTutorial.order.model.mapper;


import com.mdoner.training.RabbitmqTutorial.order.model.Order;
import com.mdoner.training.RabbitmqTutorial.order.model.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderMapper {

    @Mapping(target = "orderId", source = "id")
    @Mapping(target = "orderName", source = "name")
    OrderDTO orderToOrderDTO(Order order);

    @Mapping(target = "id", source = "orderId")
    @Mapping(target = "name", source = "orderName")
    Order orderDTOToOrder(OrderDTO orderDTO);
}
