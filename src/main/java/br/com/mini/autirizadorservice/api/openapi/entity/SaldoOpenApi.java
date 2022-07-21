package br.com.mini.autirizadorservice.api.openapi.entity;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "Saldo do cartão")
public class SaldoOpenApi {
	
	
	@Schema(example = "1200.00")
	private BigDecimal saldo;

}
