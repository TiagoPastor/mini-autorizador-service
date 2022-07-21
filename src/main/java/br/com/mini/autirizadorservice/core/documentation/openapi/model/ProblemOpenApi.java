package br.com.mini.autirizadorservice.core.documentation.openapi.model;

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
	
	@Schema(example = "400")
	private Integer status;
	
	@Schema(example = "2022-07-20T21:43:14.080632589")
	private LocalDateTime timestamp;
	
	@Schema(example = "https://mini-autorizador-service/entidade-ja-cadastrada")
	private String type;
	
	@Schema(example = "Entidade já cadastrada")
	private String title;
	
	@Schema(example = "Cartão já cadastrado")
	private String detail;

}
