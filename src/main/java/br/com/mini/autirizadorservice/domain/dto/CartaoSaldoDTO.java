package br.com.mini.autirizadorservice.domain.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class CartaoSaldoDTO {
	
	private String numeroCartao;
	private String senha;
	private BigDecimal saldo;
	
	

}
