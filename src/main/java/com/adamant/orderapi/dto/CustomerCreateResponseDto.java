package com.adamant.orderapi.dto;

import com.adamant.orderapi.entity.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class CustomerCreateResponseDto {

  private Integer id;
  @JsonProperty("first_name")
  private String firstName;
  @JsonProperty("last_name")
  private String lastName;
  private String email;
  @JsonProperty("phone_number")
  private String phoneNumber;
  private String address;
  private List<Order> orders;
}
