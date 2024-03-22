package com.adamant.cybertruckapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import java.util.Map;
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
            .title("Cybertruck API")
            .description("Cybertruck API")
            .contact(new Contact()
                .name("Daham")
                .email("dahampositha33@gmail.com")
                .url(""))
            .extensions(Map.of(
                "x-api-id", "location-api"
            ))
            .version("1.0.0")
            .license(
                new License()
                    .name("Apache 2.0")
                    .url("http://www.apache.org/licenses/LICENSE-2.0"))
        )
        .servers(List.of(
            new Server()
                .url("/")
                .description("Local Server")));
  }
}