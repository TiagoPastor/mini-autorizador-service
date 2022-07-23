package br.com.mini.autirizadorservice.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table( name = "TB_CARTAO", uniqueConstraints = {@UniqueConstraint(columnNames = {"numero"})})
public class Cartao extends AbstractEntity<Integer> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "NUMERO", length = 16)
	private String numeroCartao;
	
	@Column(name = "SENHA", length = 4)
	private String senha;

}
