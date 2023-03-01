package com.prueba.unidad.bryan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prueba.unidad.bryan.entity.Depto;

public interface IDeptoRespository extends MongoRepository<Depto, Long> {

}
