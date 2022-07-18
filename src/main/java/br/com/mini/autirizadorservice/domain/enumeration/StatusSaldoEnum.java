package br.com.mini.autirizadorservice.domain.enumeration;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum StatusSaldoEnum {
	ATIVO((short) 1, "Liberado"), 
	EXCLUIDO((short) 2, "Bloqueado");

	private static final Map<Short, StatusSaldoEnum> LOOKUP = new HashMap<>();

	static {
		for (StatusSaldoEnum e : StatusSaldoEnum.values()) {
			LOOKUP.put(e.getId(), e);
		}
	}

	public static StatusSaldoEnum valueOfId(Short id) {
		return LOOKUP.get(id);
	}

	private final Short id;
	private final String descricao;

	StatusSaldoEnum(Short id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

}

