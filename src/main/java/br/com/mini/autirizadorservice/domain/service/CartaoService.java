package br.com.mini.autirizadorservice.domain.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mini.autirizadorservice.domain.dto.CartaoDTO;
import br.com.mini.autirizadorservice.domain.dto.CartaoSaldoDTO;
import br.com.mini.autirizadorservice.domain.entity.Cartao;
import br.com.mini.autirizadorservice.domain.entity.Saldo;
import br.com.mini.autirizadorservice.domain.enumeration.StatusEnum;
import br.com.mini.autirizadorservice.domain.exception.EntidadeJaCadastradaException;
import br.com.mini.autirizadorservice.domain.repository.CartaoRepository;

@Service
public class CartaoService extends AbstractService {

	@Autowired
	private CartaoRepository cartaoRepository;

	@Autowired
	private SaldoService saldoService;

	private static final BigDecimal creditoInicial = new BigDecimal("500.00");
	
	

	public CartaoDTO create(final CartaoDTO cartaoDTO) {

		if (cartaoExistente(cartaoDTO.getNumeroCartao())) {
			throw new EntidadeJaCadastradaException("Cartão já cadastrado");
		}
		Cartao cartao = convertToEntity(cartaoDTO, Cartao.class);
		cartao.setStatus(StatusEnum.ATIVO);

		cartao = cartaoRepository.save(cartao);
		saldoService.addCredito(cartao, creditoInicial);

		return convertToDTO(cartao, CartaoDTO.class);
	}	
	
	
	public BigDecimal getSaldo(final String numeroCartao) {
		return saldoService.getSaldo(numeroCartao).getSaldo();
	}
	
	

	public boolean cartaoExistente(String numeroCartao) {
		return cartaoRepository.findByNumeroCartao(numeroCartao).isPresent();
	}

	
	
	private CartaoSaldoDTO prepareCartaoSaldo(Cartao cartao, Saldo saldo) {
		return CartaoSaldoDTO.builder().numeroCartao(cartao.getNumeroCartao()).senha(cartao.getSenha())
				.saldo(saldo.getSaldo()).build();

	}

}
