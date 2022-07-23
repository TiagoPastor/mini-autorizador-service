package br.com.mini.autirizadorservice.domain.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoDTO {
	
	
	@NotBlank
	private String numeroCartao;
	
	@NotBlank
	private String senhaCartao;
	
	@NotNull
	private BigDecimal valor;

}
