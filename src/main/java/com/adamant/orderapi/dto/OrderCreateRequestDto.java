package com.adamant.orderapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;

@Data
public class OrderCreateRequestDto {

  @JsonProperty("customer_id")
  private Integer customerId;
  @JsonProperty("order_date")
  private Date orderDate;
}
