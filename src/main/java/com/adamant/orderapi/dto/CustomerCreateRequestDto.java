package com.adamant.orderapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomerCreateRequestDto {

  @JsonProperty("first_name")
  private String firstName;
  @JsonProperty("last_name")
  private String lastName;
  private String email;
  @JsonProperty("phone_number")
  private String phoneNumber;
  private String address;
}
