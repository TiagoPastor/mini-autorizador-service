package br.com.mini.autirizadorservice.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import br.com.mini.autirizadorservice.domain.enumeration.StatusEnum;
import br.com.mini.autirizadorservice.domain.enumeration.StatusEnumConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
public abstract class AbstractEntity<I extends Serializable> {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected I id;
	
	@Column(name = "ID_STATUS")
	@Convert(converter = StatusEnumConverter.class)
	protected StatusEnum status;

}
