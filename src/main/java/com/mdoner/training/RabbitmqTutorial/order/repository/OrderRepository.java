package com.mdoner.training.RabbitmqTutorial.order.repository;

import com.mdoner.training.RabbitmqTutorial.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
}
