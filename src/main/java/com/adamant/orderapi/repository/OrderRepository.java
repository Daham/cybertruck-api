package com.adamant.orderapi.repository;

import com.adamant.orderapi.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, String> {
}
