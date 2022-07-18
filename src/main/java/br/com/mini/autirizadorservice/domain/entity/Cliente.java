package br.com.mini.autirizadorservice.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_CLIENTE")
public class Cliente extends AbstractEntity<Integer>{
	
	
	@Column(name = "NOME", length = 30 )
	private String nome;
	
	@Column(name = "SOBRENOME", length = 80)
	private String sobrenome;

}
