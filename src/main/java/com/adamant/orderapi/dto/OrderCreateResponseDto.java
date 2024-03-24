package com.adamant.orderapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;

@Data
public class OrderCreateResponseDto {
  private Integer id;

  @JsonProperty("customer_id")
  private Integer customerId;

  @JsonProperty("order_date")
  private Date orderDate;

  @JsonProperty("total_amount")
  private Double totalAmount;
}
