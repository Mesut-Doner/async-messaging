package com.mdoner.training.RabbitmqTutorial.shipping.model.mapper;

import com.mdoner.training.RabbitmqTutorial.shipping.model.Shipping;
import com.mdoner.training.RabbitmqTutorial.shipping.model.dto.ShippingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShippingMapper {

    ShippingMapper INSTANCE = Mappers.getMapper(ShippingMapper.class);

    @Mapping(target = "id", ignore = true)
    ShippingDTO toDTO(Shipping shipping);

    @Mapping(target = "id", ignore = false)
    Shipping toEntity(ShippingDTO shippingDTO);
}
