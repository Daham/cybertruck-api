package com.adamant.orderapi.service;

import com.adamant.orderapi.dto.CustomerCreateRequestDto;
import com.adamant.orderapi.dto.CustomerCreateResponseDto;

public interface CustomerService {
  CustomerCreateResponseDto save(CustomerCreateRequestDto customerCreateRequestDTO);
}
