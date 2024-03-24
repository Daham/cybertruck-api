package com.adamant.orderapi.controller;

import com.adamant.orderapi.dto.ProductCreateRequestDto;
import com.adamant.orderapi.dto.ProductCreateResponseDto;
import com.adamant.orderapi.service.ProductService;
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
public class ProductController {
  private final ProductService productService;

  @Operation(
      summary = "Create a product",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "Successfully created a product")
      }
  )
  @PostMapping("/products")
  public ResponseEntity<ProductCreateResponseDto> createProduct(
      @Parameter(
          description = "Product to create. Cannot null or empty.",
          required = true,
          schema = @Schema(
              implementation = ProductCreateRequestDto.class
          ))
      @Valid @RequestBody ProductCreateRequestDto productCreateRequestDto) {

    return new ResponseEntity<>(productService.save(productCreateRequestDto), HttpStatus.CREATED);
  }

}
