package com.adamant.orderapi.repository;

import com.adamant.orderapi.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
}
