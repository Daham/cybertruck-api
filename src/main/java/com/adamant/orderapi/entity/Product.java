package com.adamant.orderapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Product {
  @Id
  @SequenceGenerator(name = "product_product_id_seq",
      sequenceName = "product_product_id_seq",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = "product_product_id_seq")
  @Column(name = "product_id")
  private Integer id;
  private String name;
  private String description;
  private Double price;
  @OneToMany(mappedBy = "product")
  private List<OrderItem> orderItems;
}
