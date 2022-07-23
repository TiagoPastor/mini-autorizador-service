package br.com.mini.autirizadorservice.api.openapi.controller;

import org.springframework.http.ResponseEntity;

import br.com.mini.autirizadorservice.api.openapi.entity.ProblemOpenApi;
import br.com.mini.autirizadorservice.domain.dto.TransacaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Transação")
public interface TransacaoControllerOpenApi {
	
	
	@Operation(summary =  "Realizando uma transação")
	@ApiResponse(responseCode = "201", description = "Transação realizda com sucesso",
	content = { @Content(mediaType = "text/plain;charset=UTF-8",
	schema = @Schema( example = "OK"))})
	@ApiResponse(responseCode = "422", description = "Trasação não autorizada",
	content = { @Content(mediaType = "text/plain;charset=UTF-8",
	schema = @Schema( example = "CARTAO_INEXISTENTE"))})
	@ApiResponse(responseCode = "400", description = "Erro de sintaxe",
	content = { @Content(mediaType = "application/json",
	schema = @Schema(implementation = ProblemOpenApi.class))})
	public ResponseEntity<?> transacao(final TransacaoDTO transacaoDTO);

}
