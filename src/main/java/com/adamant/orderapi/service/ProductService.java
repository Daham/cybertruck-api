package com.adamant.orderapi.service;

import com.adamant.orderapi.dto.ProductCreateRequestDto;
import com.adamant.orderapi.dto.ProductCreateResponseDto;
import com.adamant.orderapi.dto.ProductsResponseDTO;

public interface ProductService {
  ProductCreateResponseDto save(ProductCreateRequestDto productCreateRequestDto);

  ProductsResponseDTO getAllProducts();
}
