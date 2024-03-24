package com.adamant.orderapi.service.impl;

import com.adamant.orderapi.dto.ProductCreateRequestDto;
import com.adamant.orderapi.dto.ProductCreateResponseDto;
import com.adamant.orderapi.entity.Product;
import com.adamant.orderapi.repository.ProductRepository;
import com.adamant.orderapi.service.ProductService;
import com.adamant.orderapi.util.ModelUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;

  @Override
  public ProductCreateResponseDto save(ProductCreateRequestDto productCreateRequestDto) {
    return ModelUtility.mapDtoToEntity(
        productRepository.save(
            ModelUtility.mapDtoToEntity(productCreateRequestDto, Product.class)),
        ProductCreateResponseDto.class);
  }
}
