package br.com.mini.autirizadorservice.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.mini.autirizadorservice.domain.document.AbstractDocument;
import br.com.mini.autirizadorservice.domain.entity.AbstractEntity;

public class AbstractService {
	
	protected static final String ID_PATH_VARIABLE = "/{id:^(?!count|all|public).+}";

	@Autowired
	protected ModelMapper modelMapper;

	protected <D, T> D convertEntityToDTO(final T model, final Class<D> dtoClass) {
		return model != null ? modelMapper.map(model, dtoClass) : null;
	}

	protected <D, E extends AbstractDocument> E convertToDocument(final D dto, final Class<E> entityClass) {
		return modelMapper.map(dto, entityClass);
	}

	protected <D, E extends AbstractDocument> E convertToDocument(final D dto, final String id, final Class<E> entityClass) {
		E entity = modelMapper.map(dto, entityClass);
		entity.setId(id);

		return entity;
	}
	

	protected <D, T> List<D> convertToDTO(final Iterable<T> models, final Class<D> dtoClass) {
		List<D> dtos = new ArrayList<>();
		for (T model : models) {
			dtos.add(modelMapper.map(model, dtoClass));
		}

		return dtos;
	}

	protected <D, T> Page<D> convertToDTO(final Page<T> page, final Class<D> dtoClass) {
		return new PageImpl<>(convertToDTO(page.getContent(), dtoClass), page.getPageable(), page.getTotalElements());
	}
	

	protected <D, T> D convertToDTO(final T model, final Class<D> dtoClass) {
		return model != null ? modelMapper.map(model, dtoClass) : null;
	}
	
	
	protected <D, E extends AbstractEntity<I>, I extends Serializable> E convertToEntity(final D dto, final Class<E> entityClass) {
		E entity = modelMapper.map(dto, entityClass);
		//entity.setId(id);

		return entity;
	}

}
