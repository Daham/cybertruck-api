package com.adamant.orderapi.controller;

import com.adamant.orderapi.dto.CustomerCreateRequestDto;
import com.adamant.orderapi.dto.CustomerCreateResponseDto;
import com.adamant.orderapi.dto.CustomersResponseDTO;
import com.adamant.orderapi.dto.ProductsResponseDTO;
import com.adamant.orderapi.service.CustomerService;
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
public class CustomerController {
  private final CustomerService customerService;

  @Operation(
      summary = "Retrieve all customers",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Successfully retrieved all customers"
          )
      }
  )
  @GetMapping(value = "/customers")
  public ResponseEntity<CustomersResponseDTO> retrieveItem(
      @Parameter(description = "Rows per page", example = "10")
      @RequestParam(name = "rowsPerPage") int rowsPerPage,

      @Parameter(description = "Search param")
      @RequestParam(name = "param", required = false) String param) {

    return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
  }


  @Operation(
      summary = "Create a customer",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "Successfully created a customer")
      }
  )
  @PostMapping("/customers")
  public ResponseEntity<CustomerCreateResponseDto> createCustomer(
      @Parameter(
          description = "Customer to create. Cannot null or empty.",
          required = true,
          schema = @Schema(
              implementation = CustomerCreateRequestDto.class
          ))
      @Valid @RequestBody CustomerCreateRequestDto customerCreateRequestDTO) {

    return new ResponseEntity<>(customerService.save(customerCreateRequestDTO), HttpStatus.CREATED);
  }

}
