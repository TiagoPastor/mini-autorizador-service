package br.com.mini.autirizadorservice.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mini.autirizadorservice.domain.dto.CartaoDTO;
import br.com.mini.autirizadorservice.domain.entity.Cartao;
import br.com.mini.autirizadorservice.domain.enumeration.StatusEnum;
import br.com.mini.autirizadorservice.domain.exception.EntidadeJaCadastradaException;
import br.com.mini.autirizadorservice.domain.repository.CartaoRepository;

@Service
public class CartaoService extends AbstractService{
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	
	public CartaoDTO create (final CartaoDTO cartaoDTO){
		
		if(cartaoExistente(cartaoDTO.getNumero())) {
			throw new EntidadeJaCadastradaException("Cartão já cadastrado");			
		}
			Cartao cartao = convertToEntity(cartaoDTO, Cartao.class);
			cartao.setStatus(StatusEnum.ATIVO);
			
			return convertToDTO(cartaoRepository.save(cartao), CartaoDTO.class);
	}
	
	
	
	public boolean cartaoExistente(String numeroCartao) {
		return cartaoRepository.findByNumero(numeroCartao).isPresent();
	}
	

}
