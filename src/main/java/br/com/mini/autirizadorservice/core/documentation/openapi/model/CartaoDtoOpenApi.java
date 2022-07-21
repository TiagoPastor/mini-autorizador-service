package br.com.mini.autirizadorservice.core.documentation.openapi.model;

import javax.validation.constraints.NotBlank;

import br.com.mini.autirizadorservice.domain.enumeration.StatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Cartao")
public class CartaoDtoOpenApi {
	

	private Integer id;
	
	private StatusEnum status;
	
	@NotBlank
	private String numero;
	
	@NotBlank
	private String senha;

}
