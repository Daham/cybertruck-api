package com.adamant.orderapi.controller;

import com.adamant.orderapi.dto.ProductCreateRequestDto;
import com.adamant.orderapi.dto.ProductCreateResponseDto;
import com.adamant.orderapi.dto.ProductsResponseDTO;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;

  @Operation(
      summary = "Retrieve all products",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Successfully retrieved all products"
          )
      }
  )
  @GetMapping(value = "/products")
  public ResponseEntity<ProductsResponseDTO> retrieveItem(
      @Parameter(description = "Rows per page", example = "10")
      @RequestParam(name = "rowsPerPage") int rowsPerPage,

      @Parameter(description = "Search param")
      @RequestParam(name = "param", required = false) String param) {

    return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
  }


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
