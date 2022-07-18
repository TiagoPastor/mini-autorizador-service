package br.com.mini.autirizadorservice.exception;

public class EntidadeJaCadastradaException extends BusinessException {

	private static final long serialVersionUID = 1L;
	
	private static final String MSG_ENTIDADE_CADASTRADA = "Entidade já cadastrada";
	
	public EntidadeJaCadastradaException() {
		super(MSG_ENTIDADE_CADASTRADA);
	}

	public EntidadeJaCadastradaException(String mensagem) {
		super(mensagem);
	}
	
}
