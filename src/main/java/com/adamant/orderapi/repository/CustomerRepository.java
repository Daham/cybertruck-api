package com.adamant.orderapi.repository;

import com.adamant.orderapi.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {
}
