package com.adamant.orderapi.service.impl;

import com.adamant.orderapi.dto.OrderCreateRequestDto;
import com.adamant.orderapi.dto.OrderCreateResponseDto;
import com.adamant.orderapi.entity.Order;
import com.adamant.orderapi.mapper.OrderMapper;
import com.adamant.orderapi.repository.CustomerRepository;
import com.adamant.orderapi.repository.OrderRepository;
import com.adamant.orderapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

  private final CustomerRepository customerRepository;

  private final OrderMapper orderMapper;

  @Override
  public OrderCreateResponseDto save(OrderCreateRequestDto orderCreateRequestDto) {

    Order order = orderMapper.convertDtoToEntity(orderCreateRequestDto, customerRepository);
    Order savedOrder = orderRepository.save(order);
    return orderMapper.concertEntityToDto(savedOrder);
  }
}
