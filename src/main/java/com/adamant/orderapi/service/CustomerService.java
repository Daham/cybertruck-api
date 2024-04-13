package com.adamant.orderapi.service;

import com.adamant.orderapi.dto.CustomerCreateRequestDto;
import com.adamant.orderapi.dto.CustomerCreateResponseDto;
import com.adamant.orderapi.dto.CustomersResponseDTO;

public interface CustomerService {
  CustomerCreateResponseDto save(CustomerCreateRequestDto customerCreateRequestDTO);

  CustomersResponseDTO getAllCustomers();
}
