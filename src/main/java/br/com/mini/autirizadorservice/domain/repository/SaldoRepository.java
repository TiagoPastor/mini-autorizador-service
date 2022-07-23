package br.com.mini.autirizadorservice.domain.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mini.autirizadorservice.domain.entity.Cartao;
import br.com.mini.autirizadorservice.domain.entity.Saldo;


@Repository
public interface SaldoRepository extends JpaRepository<Saldo, Integer>{
	
	@Query("SELECT s FROM Saldo s "
			+ "INNER JOIN Cartao c ON (s.cartao.id = c.id)"
			+ "  WHERE c.numeroCartao = :numeroCartao ")
	Optional<Saldo> findByNumeroCartao(@Param("numeroCartao") final String numeroCartao);
	
	Optional<Saldo> findByCartao(Cartao cartao);
	
	@Query("SELECT s FROM Saldo s "
			+ "INNER JOIN Cartao c ON (s.cartao.id = c.id)"
			+ "  WHERE c.numeroCartao = :numeroCartao AND s.saldo >= :saldo")
	Optional<Saldo> findBySaldoPositivo(@Param("numeroCartao") final String numeroCartao, @Param("saldo") final BigDecimal saldo);

}
