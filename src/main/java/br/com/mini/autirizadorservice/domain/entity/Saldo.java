package br.com.mini.autirizadorservice.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "TB_SALDO")
public class Saldo extends AbstractSaldoEntity<Integer>{
	
	@Column(name = "SALDO")
	private BigDecimal saldo;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_SALDO_CLIENTE"))
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn(name = "ID_CARTAO", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_SALDO_CARTAO"))
	private Cartao cartao;

}
