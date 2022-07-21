package br.com.mini.autirizadorservice.domain.dto;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class SaldoDTO {
	
	private Integer id;
	
	private BigDecimal saldo;

	
	private CartaoDTO cartao;

}
