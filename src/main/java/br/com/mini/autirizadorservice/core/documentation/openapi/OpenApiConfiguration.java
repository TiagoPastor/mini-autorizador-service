package br.com.mini.autirizadorservice.core.documentation.openapi;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(info = 
@Info(title = "Mini autorizador service",
      version = "v1",
      description = "Documentão da API mini-autirizador-service"))
public class OpenApiConfiguration {

	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components())
				.info(
                   new io.swagger.v3.oas.models.info.Info()
                   .title("Mini Autorizador service API")
                   .version("V1")
                   .license(
                		   new License()
                		       .name("Apache 2.0")
                		       .url("http://springdoc.org")
                   )
                );
	}

}

