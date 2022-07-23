package br.com.mini.autirizadorservice.domain.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mini.autirizadorservice.domain.dto.TransacaoDTO;
import br.com.mini.autirizadorservice.domain.entity.Cartao;
import br.com.mini.autirizadorservice.domain.entity.Saldo;
import br.com.mini.autirizadorservice.domain.exception.UnprocessableEntityException;

@Service
public class TransacaoService extends AbstractService{
	
	
	private static final String SALDO_INSUFICIENTE = "SALDO_INSUFICIENTE";
	
	private static final String SENHA_INVALIDA = "SENHA_INVALIDA";
	
	private static final String CARTAO_INEXISTENTE = "CARTAO_INEXISTENTE";
	
	@Autowired
	private CartaoService cartcaoService;
	
	@Autowired
	private SaldoService saldoService;
	
	
	
	public void transacao(TransacaoDTO transasaoDTO) {
		
		Optional<Cartao> cartaoOptional = cartcaoService.buscarCartao(transasaoDTO.getNumeroCartao());
		
		cartaoOptional.ifPresentOrElse((cartao) -> {
			validateSenha(transasaoDTO, cartao);
		}, () -> {
			throw new UnprocessableEntityException(CARTAO_INEXISTENTE);
		});
		
		Optional<Saldo> saldoOption = saldoService.consultarSaldo(transasaoDTO.getNumeroCartao(), transasaoDTO.getValor());
		
		saldoOption.ifPresentOrElse((saldo) -> {
			debitarCredito(saldo, transasaoDTO.getValor());
		}, () -> {
			throw new UnprocessableEntityException(SALDO_INSUFICIENTE);
			
		});
			
	}
	
	private void debitarCredito(Saldo saldo, BigDecimal valorADebitar) {
		
		saldo.setSaldo(saldo.getSaldo().subtract(valorADebitar));	
		saldoService.atualizarSaldo(saldo);
		
	}
	
	
	private void validateSenha(TransacaoDTO transacao, Cartao cartao) {
		if(!transacao.getSenhaCartao().equals(cartao.getSenha())) {
			throw new UnprocessableEntityException(SENHA_INVALIDA);
		}
		
	}
}
