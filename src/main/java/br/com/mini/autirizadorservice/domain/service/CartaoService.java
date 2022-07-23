package br.com.mini.autirizadorservice.domain.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mini.autirizadorservice.domain.dto.CartaoDTO;
import br.com.mini.autirizadorservice.domain.entity.Cartao;
import br.com.mini.autirizadorservice.domain.enumeration.StatusEnum;
import br.com.mini.autirizadorservice.domain.exception.CartaoJaCadastradoException;
import br.com.mini.autirizadorservice.domain.repository.CartaoRepository;

@Service
public class CartaoService extends AbstractService {

	@Autowired
	private CartaoRepository cartaoRepository;

	@Autowired
	private SaldoService saldoService;

	private static final BigDecimal CREDITO_INICIAL = new BigDecimal("500.00");
	
	

	public CartaoDTO create(final CartaoDTO cartaoDTO) {
		
		if (buscarCartao(cartaoDTO.getNumeroCartao()).isPresent()) {
			throw new CartaoJaCadastradoException(cartaoDTO);		
		}
		
		Cartao cartao = convertToEntity(cartaoDTO, Cartao.class);
		cartao.setStatus(StatusEnum.ATIVO);

		cartao = cartaoRepository.save(cartao);
		saldoService.addCredito(cartao, CREDITO_INICIAL);

		return convertToDTO(cartao, CartaoDTO.class);
	}	
	
	
	public BigDecimal getSaldo(final String numeroCartao) {
		return saldoService.getSaldo(numeroCartao).getSaldo();
	}
	
	
	
	public Optional<Cartao> buscarCartao(String numeroCartao){
		return cartaoRepository.findByNumeroCartao(numeroCartao);
		
	}


}
