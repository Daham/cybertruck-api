package com.adamant.cybertruckapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Swagger configuration.
 */
@Configuration
public class SwaggerConfiguration {

  /**
   * Custom open api open api.
   *
   * @return the open api
   */
  @Bean
  public OpenAPI customOpenApi() {
    return new OpenAPI()
        .info(new Info()
            .title("cybertruck-api")
            .version("1.0.0")
        )
        .servers(List.of(
            new Server()
                .url("http://localhost:8080")));
  }
}