package br.com.mini.autirizadorservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BusinessException extends RuntimeException  {

	private static final long serialVersionUID = 1L;
	
	
	public BusinessException(String mensagem) {
		super(mensagem);
	}
	
	public BusinessException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}