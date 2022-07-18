package br.com.mini.autirizadorservice.domain.dto;

import javax.validation.constraints.NotBlank;

import br.com.mini.autirizadorservice.domain.enumeration.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartaoDTO {
	
	
	private Integer id;
	
	private StatusEnum status;
	
	@NotBlank
	private String numero;
	@NotBlank
	private String senha;

}
