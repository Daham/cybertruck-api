package com.adamant.orderapi.service.impl;

import com.adamant.orderapi.dto.ProductCreateRequestDto;
import com.adamant.orderapi.dto.ProductCreateResponseDto;
import com.adamant.orderapi.dto.ProductsResponseDTO;
import com.adamant.orderapi.entity.Product;
import com.adamant.orderapi.repository.ProductRepository;
import com.adamant.orderapi.service.ProductService;
import com.adamant.orderapi.util.ModelUtility;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public ProductCreateResponseDto save(ProductCreateRequestDto productCreateRequestDto) {
    return ModelUtility.mapDtoToEntity(
        productRepository.save(
            ModelUtility.mapDtoToEntity(productCreateRequestDto, Product.class)),
        ProductCreateResponseDto.class);
  }

  @Override
  public ProductsResponseDTO getAllProducts() {
    return ProductsResponseDTO.builder()
        .items(IterableUtils.toList(productRepository.findAll()))
        .build();
  }
}
