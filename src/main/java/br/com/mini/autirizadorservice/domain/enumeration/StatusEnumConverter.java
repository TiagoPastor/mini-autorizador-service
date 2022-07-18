package br.com.mini.autirizadorservice.domain.enumeration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StatusEnumConverter implements AttributeConverter<StatusEnum, Short> {

	@Override
	public Short convertToDatabaseColumn(final StatusEnum statusEnum) {
		return statusEnum != null ? statusEnum.getId() : null;
	}

	@Override
	public StatusEnum convertToEntityAttribute(final Short id) {
		return StatusEnum.valueOfId(id);
	}

}
