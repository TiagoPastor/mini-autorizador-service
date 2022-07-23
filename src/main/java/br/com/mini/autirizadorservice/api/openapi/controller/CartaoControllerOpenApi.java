package br.com.mini.autirizadorservice.api.openapi.controller;

import java.math.BigDecimal;

import br.com.mini.autirizadorservice.api.openapi.entity.ProblemOpenApi;
import br.com.mini.autirizadorservice.domain.dto.CartaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cartões")
public interface CartaoControllerOpenApi {
	
	
	@Operation(summary =  "Cadastrar um novo cartão")
	@ApiResponse(responseCode = "201", description = "Cartão cadastrado com sucesso",
	content = { @Content(mediaType = "application/json",
	schema = @Schema(implementation = CartaoDTO.class))})
	@ApiResponse(responseCode = "422", description = "Não é permitido cadastrar mais de um cartão com o mesmo número",
	content = { @Content(mediaType = "application/json",
	schema = @Schema(implementation = CartaoDTO.class))})
	@ApiResponse(responseCode = "400", description = "Erro de sintaxe",
	content = { @Content(mediaType = "application/json",
	schema = @Schema(implementation = ProblemOpenApi.class))})
	public CartaoDTO create(final CartaoDTO cartaoDTO);
	
	@Operation(summary =  "Consultar saldo pelo número do cartão")
	@ApiResponse(responseCode = "200", description = "Saldo encontrado")
	@ApiResponse(responseCode = "404", description = "Saldo não encontrado para o cartão informado",
	content = { @Content(mediaType = "application/json")})
	public BigDecimal getSaldoCartao(final String numeroCartao);

}
