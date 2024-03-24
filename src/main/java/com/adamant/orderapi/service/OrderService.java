package com.adamant.orderapi.service;

import com.adamant.orderapi.dto.OrderCreateRequestDto;
import com.adamant.orderapi.dto.OrderCreateResponseDto;

public interface OrderService {
  OrderCreateResponseDto save(OrderCreateRequestDto orderCreateRequestDto);
}
