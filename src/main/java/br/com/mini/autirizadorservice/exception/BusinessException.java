package br.com.mini.autirizadorservice.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BusinessException extends RuntimeException  {

	private static final long serialVersionUID = 1L;
	
	
	public BusinessException(String mensagem) {
		super(mensagem);
	}
	
	public BusinessException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}