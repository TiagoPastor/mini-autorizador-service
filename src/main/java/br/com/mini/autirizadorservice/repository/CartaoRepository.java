package br.com.mini.autirizadorservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mini.autirizadorservice.domain.entity.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Integer>{
	
	Optional<Cartao> findByNumero(String numero);

}
