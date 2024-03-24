package com.adamant.orderapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "order_item")
public class OrderItem {
  @Id
  @SequenceGenerator(name = "order_item_order_item_id_seq",
      sequenceName = "order_item_order_item_id_seq",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = "order_item_order_item_id_seq")
  @Column(name = "order_item_id")
  private Integer id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id")
  private Order order;
  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;
  private Integer quantity;
  @Column(name = "unit_price")
  private Double unitPrice;
}
