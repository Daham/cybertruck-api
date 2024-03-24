package com.adamant.orderapi.service;

import com.adamant.orderapi.dto.ProductCreateRequestDto;
import com.adamant.orderapi.dto.ProductCreateResponseDto;

public interface ProductService {
  ProductCreateResponseDto save(ProductCreateRequestDto productCreateRequestDto);
}
