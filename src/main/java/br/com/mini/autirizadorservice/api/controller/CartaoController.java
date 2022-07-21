package br.com.mini.autirizadorservice.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mini.autirizadorservice.api.openapi.controller.CartaoControllerOpenApi;
import br.com.mini.autirizadorservice.domain.dto.CartaoDTO;
import br.com.mini.autirizadorservice.domain.service.CartaoService;


@RestController
@RequestMapping(path = "/cartoes", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CartaoController implements CartaoControllerOpenApi {
	
	
	@Autowired
	private CartaoService cartaoService;
	
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CartaoDTO create(@RequestBody @Valid final CartaoDTO cartaoDTO){
		return cartaoService.create(cartaoDTO);
	}
	

}
