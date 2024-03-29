package br.com.mini.autirizador.service.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.mini.autirizadorservice.domain.entity.Cartao;
import br.com.mini.autirizadorservice.domain.enumeration.StatusEnum;
import br.com.mini.autirizadorservice.domain.repository.CartaoRepository;
import br.com.mini.autirizadorservice.domain.repository.SaldoRepository;



@DisplayName("Cartao Controller")
public class CartaoControllerIT extends BaseControllerIT {

	
	private static final String RESOURCE_BASE_URL = "/cartoes";

	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private SaldoRepository saldoRepository;
	
	
	@BeforeEach
	public void setUp() {	
		saldoRepository.deleteAll();
		cartaoRepository.deleteAll();
	}
	

	
	@Nested
	@DisplayName("POST: cartoes/ ")
	class Post {
		
		@Test
		@DisplayName("Deve retornar um cartão cadastrado. status HTTP 201")
		void postCreateCartao(){
			
			Cartao cartao = new Cartao();
			cartao.setNumeroCartao(gerarNumeroCartao());
			cartao.setSenha(gerarSenhaCartao());
			
			StringBuilder url = new StringBuilder(RESOURCE_BASE_URL);
			HttpEntity<Cartao> request = new HttpEntity<>(cartao);
			ResponseEntity<Cartao> response = restTemplate.exchange(url.toString(), HttpMethod.POST, request, Cartao.class);
			
			assertNotNull(response);
			assertNotNull(response.getBody().getNumeroCartao());
			assertEquals(HttpStatus.CREATED, response.getStatusCode());

			
		}
		
		@Test
		@DisplayName("Não deve permitir cadastrar mais de um cartão com mesmo número. status HTTP 400")
		void postCreateCartaoJaCadastrado(){
		
			Cartao cartao = criarCartao();
			Cartao novoCartao = new Cartao();
			novoCartao.setNumeroCartao(cartao.getNumeroCartao());
			novoCartao.setSenha(gerarSenhaCartao());
			
			StringBuilder url = new StringBuilder(RESOURCE_BASE_URL);
			HttpEntity<Cartao> request = new HttpEntity<>(novoCartao);
			ResponseEntity<Object> response = restTemplate.exchange(url.toString(), HttpMethod.POST, request, Object.class);
			
			assertNotNull(response);
			assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());

			
		}
		
		@Test
		@DisplayName("Não deve permitir cadastrar cartão sem o número. status HTTP 400")
		void postCreateCartaoSemNumero(){
		
			Cartao novoCartao = new Cartao();
			novoCartao.setSenha(gerarSenhaCartao());
			
			StringBuilder url = new StringBuilder(RESOURCE_BASE_URL);
			HttpEntity<Cartao> request = new HttpEntity<>(novoCartao);
			ResponseEntity<Object> response = restTemplate.exchange(url.toString(), HttpMethod.POST, request, Object.class);
			
			assertNotNull(response);
			assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

			
		}
		
		@Test
		@DisplayName("Não deve permitir cadastrar cartão sem a senha. status HTTP 400")
		void postCreateCartaoSemSenha(){
		
			Cartao novoCartao = new Cartao();
			novoCartao.setNumeroCartao(gerarNumeroCartao());
			
			StringBuilder url = new StringBuilder(RESOURCE_BASE_URL);
			HttpEntity<Cartao> request = new HttpEntity<>(novoCartao);
			ResponseEntity<Object> response = restTemplate.exchange(url.toString(), HttpMethod.POST, request, Object.class);
			
			assertNotNull(response);
			assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

			
		}
		
	}
	
	
	
	
	private Cartao criarCartao() {
        return cartaoRepository.save(Cartao.builder()
        .numeroCartao(gerarNumeroCartao())
        .senha(gerarSenhaCartao())
        .status(StatusEnum.ATIVO).build());
	}
	
	private String gerarNumeroCartao() {
		return faker.numerify("################");
	}
	
	private String gerarSenhaCartao() {
		return faker.numerify("####");		
	}
	

}
