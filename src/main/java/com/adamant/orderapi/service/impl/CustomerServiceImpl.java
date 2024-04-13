package com.adamant.orderapi.service.impl;

import com.adamant.orderapi.dto.CustomerCreateRequestDto;
import com.adamant.orderapi.dto.CustomerCreateResponseDto;
import com.adamant.orderapi.dto.CustomersResponseDTO;
import com.adamant.orderapi.dto.ProductsResponseDTO;
import com.adamant.orderapi.entity.Customer;
import com.adamant.orderapi.repository.CustomerRepository;
import com.adamant.orderapi.service.CustomerService;
import com.adamant.orderapi.util.ModelUtility;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

/**
 * The type Customer service.
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;

  @Override
  public CustomerCreateResponseDto save(CustomerCreateRequestDto customerCreateRequestDto) {


    return ModelUtility.mapDtoToEntity(
        customerRepository.save(
            ModelUtility.mapDtoToEntity(customerCreateRequestDto, Customer.class)
        ),
        CustomerCreateResponseDto.class);
  }

  @Override
  public CustomersResponseDTO getAllCustomers() {
    return CustomersResponseDTO.builder()
        .items(IterableUtils.toList(customerRepository.findAll()))
        .build();
  }

}
