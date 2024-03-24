package com.adamant.orderapi.mapper;

import com.adamant.orderapi.dto.OrderCreateRequestDto;
import com.adamant.orderapi.dto.OrderCreateResponseDto;
import com.adamant.orderapi.entity.Order;
import com.adamant.orderapi.repository.CustomerRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMapper {

  @Mapping(target = "customer", ignore = true)
  Order convertDtoToEntity(OrderCreateRequestDto orderCreateRequestDto,
            @Context CustomerRepository customerRepository);

  @Mapping(target = "customerId", ignore = true)
  OrderCreateResponseDto concertEntityToDto(Order order);

  @AfterMapping
  default void convertDtoToEntity(@MappingTarget Order order, OrderCreateRequestDto orderCreateRequestDto,
                                  @Context CustomerRepository customerRepository) {
    order.setCustomer(
        customerRepository.findById(orderCreateRequestDto.getCustomerId().toString()).orElse(null));
    order.setTotalAmount(0.00);
  }
  @AfterMapping
  default void concertEntityToDto(@MappingTarget OrderCreateResponseDto orderCreateResponseDto, Order order) {
    orderCreateResponseDto.setCustomerId(order.getCustomer().getId());
  }

}
