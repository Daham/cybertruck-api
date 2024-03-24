package com.adamant.orderapi.controller;

import com.adamant.orderapi.dto.OrderCreateRequestDto;
import com.adamant.orderapi.dto.OrderCreateResponseDto;
import com.adamant.orderapi.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
public class OrderController {
  private final OrderService orderService;

  @Operation(
      summary = "Create an order",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "Successfully created an order")
      }
  )
  @PostMapping("/orders")
  public ResponseEntity<OrderCreateResponseDto> createOrder(
      @Parameter(
          description = "Order to create. Cannot null or empty.",
          required = true,
          schema = @Schema(
              implementation = OrderCreateRequestDto.class
          ))
      @Valid @RequestBody OrderCreateRequestDto orderCreateRequestDto) {

    return new ResponseEntity<>(orderService.save(orderCreateRequestDto), HttpStatus.CREATED);
  }
}
