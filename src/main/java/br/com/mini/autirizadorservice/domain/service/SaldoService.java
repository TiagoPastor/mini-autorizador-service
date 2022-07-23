package br.com.mini.autirizadorservice.domain.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mini.autirizadorservice.domain.dto.SaldoDTO;
import br.com.mini.autirizadorservice.domain.entity.Cartao;
import br.com.mini.autirizadorservice.domain.entity.Saldo;
import br.com.mini.autirizadorservice.domain.enumeration.StatusEnum;
import br.com.mini.autirizadorservice.domain.exception.EntityNotFound;
import br.com.mini.autirizadorservice.domain.repository.SaldoRepository;

@Service
public class SaldoService extends AbstractService{
	
	
	@Autowired
	private SaldoRepository saldoRepository;
	
	
	public Saldo addCredito(final Cartao cartao, final BigDecimal credito) {
		Saldo sado = Saldo.builder()
				.cartao(cartao)
				.status(StatusEnum.LIBERADO)
				.saldo(credito).build();
		return saldoRepository.save(sado);
		
	}
	
	public Optional<Saldo> consultarSaldo(final String numeroCartao, final BigDecimal valorTransacao) {
		return saldoRepository.findBySaldoPositivo(numeroCartao, valorTransacao);
	}
	
	public void atualizarSaldo(final Saldo saldo) {
		saldoRepository.save(saldo);
		
	}
	
	
	public SaldoDTO getSaldo(final String numeroCartao) {
		Optional<Saldo> saldo = saldoRepository.findByNumeroCartao(numeroCartao);
		saldo.orElseThrow(() -> {
			throw new EntityNotFound();
			});
		
		return convertToDTO(saldo.get(), SaldoDTO.class);
		
	}

}
