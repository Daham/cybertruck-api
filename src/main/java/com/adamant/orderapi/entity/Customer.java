package com.adamant.orderapi.entity;

import jakarta.persistence.CascadeType;
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
public class Customer {
  @Id
  @SequenceGenerator(name = "customer_customer_id_seq",
      sequenceName = "customer_customer_id_seq",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = "customer_customer_id_seq")
  @Column(name = "customer_id", updatable = false)
  private Integer id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  private String email;
  @Column(name = "phone_number")
  private String phoneNumber;
  private String address;
  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  private List<Order> orders;
}
