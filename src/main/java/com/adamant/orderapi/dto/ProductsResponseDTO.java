package com.adamant.orderapi.dto;

import com.adamant.orderapi.entity.Customer;
import com.adamant.orderapi.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductsResponseDTO {

  @JsonProperty("is_has_previous")
  private boolean isHasPrevious;

  @JsonProperty("is_has_next")
  private boolean isHasNext;

  @JsonProperty("total")
  private long totalResults;

  @JsonProperty("page_number")
  private int pageNumber;

  @JsonProperty("next_param")
  private String nextParam;

  @JsonProperty("previous_param")
  private String previousParam;

  private List<Product> items;
}
