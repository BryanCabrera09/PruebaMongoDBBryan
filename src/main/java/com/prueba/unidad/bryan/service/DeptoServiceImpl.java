package com.prueba.unidad.bryan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.prueba.unidad.bryan.entity.Depto;
import com.prueba.unidad.bryan.repository.IDeptoRespository;

@Service
public class DeptoServiceImpl extends GenericServiceImpl<Depto, Long> implements IDeptoService {

	@Autowired
	IDeptoRespository deptoRepository;

	@Override
	public CrudRepository<Depto, Long> getDao() {

		return deptoRepository;
	}

}
