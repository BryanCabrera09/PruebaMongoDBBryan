package com.prueba.unidad.bryan.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "depto")
@Data
public class Depto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long depto_id;

	private String nombre;
	private String director;
	private String direccion;
	
	private List<Profesor> listprofes;
}
