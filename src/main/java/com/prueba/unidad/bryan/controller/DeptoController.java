package com.prueba.unidad.bryan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.unidad.bryan.entity.Depto;
import com.prueba.unidad.bryan.service.IDeptoService;

@RestController
@RequestMapping("/api/depto")
public class DeptoController {

	@Autowired
	IDeptoService deptoService;

	@GetMapping("/listar")
	public ResponseEntity<List<Depto>> listarDepto() {
		return new ResponseEntity<>(deptoService.findByAll(), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<Depto> crearDepto(@RequestBody Depto p) {
		return new ResponseEntity<>(deptoService.save(p), HttpStatus.CREATED);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Depto> actualizarDepto(@PathVariable Long id, @RequestBody Depto p) {
		Depto DeptoENcontrada = deptoService.findById(id);
		if (DeptoENcontrada == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				DeptoENcontrada.setNombre(p.getNombre());
				DeptoENcontrada.setDirector(p.getDirector());
				DeptoENcontrada.setDireccion(p.getDireccion());
				return new ResponseEntity<>(deptoService.save(p), HttpStatus.OK);
			} catch (DataAccessException e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Depto> eliminarDepto(@PathVariable Long id) {
		deptoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
