package br.com.mini.autirizadorservice.domain.exception;

public class UnprocessableEntityException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public UnprocessableEntityException(String mensagem) {
		super(mensagem);
	}
	
	public UnprocessableEntityException() {

	}
	
}