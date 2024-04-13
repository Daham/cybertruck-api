package com.adamant.orderapi.dto;

import com.adamant.orderapi.entity.OrderItem;
import java.util.List;
import lombok.Data;

@Data
public class ProductCreateResponseDto {
  private Integer id;
  private String name;
  private String description;
  private Double price;
}
