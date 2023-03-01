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
@Document(collection = "profesor")
@Data
public class Profesor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long profesor_id;

	private String nombre;

	private String direccion;

	private String telefono;

	private List<Curso> listcursos;
}
