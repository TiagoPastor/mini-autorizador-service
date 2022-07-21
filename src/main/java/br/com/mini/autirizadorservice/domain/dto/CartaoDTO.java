package br.com.mini.autirizadorservice.domain.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Schema(title = "CartaoDTO", description = "É a entidade que representa um cartão")
public class CartaoDTO {
	
	@JsonIgnore
	private Integer id;
	
	@JsonIgnore
	private StatusEnum status;
	
	@Schema(title = "Número do cartão", 
			description = "É a entidade que representa o número do cartão", 
			example = "532698745132565")
	@NotBlank
	private String numeroCartao;
	
	@Schema(title = "Senha do cartão", 
			description = "É a entidade que representa a senha do cartão", 
			example = "5522")
	@NotBlank
	private String senha;

}
