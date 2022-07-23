package br.com.mini.autirizadorservice.domain.exception;

import br.com.mini.autirizadorservice.domain.dto.CartaoDTO;

public class CartaoJaCadastradoException extends BusinessException {

	private static final long serialVersionUID = 1L;
	
	private CartaoDTO cartaoDTO;

	public CartaoJaCadastradoException(String mensagem) {
		super(mensagem);
	}
	
	public CartaoJaCadastradoException(CartaoDTO cartaoDTO) {
		this.cartaoDTO = cartaoDTO;

	}
	
	public CartaoDTO getCartaoDTO() {
		return cartaoDTO;
	}
	
}