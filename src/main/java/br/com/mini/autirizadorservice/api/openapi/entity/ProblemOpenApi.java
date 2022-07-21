package br.com.mini.autirizadorservice.api.openapi.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
@Getter
@Builder
@Schema(title = "Problem", description = "Entidade que representa a resposta de um problema ")
public class ProblemOpenApi {
	
	@Schema
	private Integer status;
	
	@Schema
	private LocalDateTime timestamp;
	
	@Schema
	private String type;
	
	@Schema
	private String title;
	
	@Schema
	private String detail;

}
