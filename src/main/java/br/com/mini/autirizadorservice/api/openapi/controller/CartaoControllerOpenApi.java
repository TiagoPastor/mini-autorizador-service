package br.com.mini.autirizadorservice.api.openapi.controller;

import br.com.mini.autirizadorservice.api.openapi.entity.CartaoDtoOpenApi;
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
	schema = @Schema(implementation = CartaoDtoOpenApi.class))})
	@ApiResponse(responseCode = "400", description = "Não é permitido cadastrar mais de um cartão com o mesmo número",
	content = { @Content(mediaType = "application/json",
	schema = @Schema(implementation = ProblemOpenApi.class))})
	public CartaoDTO create(final CartaoDTO cartaoDTO);

}
