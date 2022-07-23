package br.com.mini.autirizadorservice.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mini.autirizadorservice.api.openapi.controller.TransacaoControllerOpenApi;
import br.com.mini.autirizadorservice.domain.dto.TransacaoDTO;
import br.com.mini.autirizadorservice.domain.service.TransacaoService;


@RestController
@RequestMapping(path = "/transacoes", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TransacaoController implements TransacaoControllerOpenApi {

	
	@Autowired
	private TransacaoService transacaoService;
	
	@PostMapping
	public ResponseEntity<?> transacao(@RequestBody @Valid TransacaoDTO transacaoDTO) {
		transacaoService.transacao(transacaoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body("OK");
		
	}

}
