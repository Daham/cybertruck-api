package com.adamant.orderapi.dto;

import lombok.Data;

@Data
public class ProductCreateRequestDto {
  private String name;
  private String description;
  private Double price;
}
