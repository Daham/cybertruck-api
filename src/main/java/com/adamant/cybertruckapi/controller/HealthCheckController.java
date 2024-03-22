package com.adamant.cybertruckapi.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.actuate.health.HealthComponent;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Health check controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/health")
public class HealthCheckController {

  private final HealthEndpoint healthEndpoint;

  /**
   * Health response entity.
   *
   * @return the response entity
   */
  @GetMapping
  public ResponseEntity<HealthComponent> health() {
    HealthComponent health = healthEndpoint.health();
    HttpStatus httpStatus =
        StringUtils.equals(Status.UP.getCode(), health.getStatus().getCode()) ? HttpStatus.OK :
            HttpStatus.SERVICE_UNAVAILABLE;

    return new ResponseEntity<>(health, httpStatus);
  }

  /**
   * Status response entity.
   *
   * @return the response entity
   */
  @GetMapping("/status")
  public ResponseEntity<Status> status() {
    Status status = healthEndpoint.health().getStatus();
    HttpStatus httpStatus =
        StringUtils.equals(Status.UP.getCode(), status.getCode()) ? HttpStatus.OK :
            HttpStatus.SERVICE_UNAVAILABLE;

    return new ResponseEntity<>(status, httpStatus);
  }
}
