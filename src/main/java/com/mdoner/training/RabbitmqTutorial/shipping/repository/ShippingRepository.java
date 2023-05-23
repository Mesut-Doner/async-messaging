package com.mdoner.training.RabbitmqTutorial.shipping.repository;

import com.mdoner.training.RabbitmqTutorial.shipping.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping,String> {
}
