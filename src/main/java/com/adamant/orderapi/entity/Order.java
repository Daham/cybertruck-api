package com.adamant.orderapi.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "order_header")
public class Order {
  @Id
  @SequenceGenerator(name = "order_header_order_id_seq",
      sequenceName = "order_header_order_id_seq",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = "order_header_order_id_seq")
  @Column(name = "order_id")
  private Integer id;
  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<OrderItem> orderItems;
  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "order_date")
  private Date orderDate;

  @Column(name = "total_amount")
  private Double totalAmount;
}
